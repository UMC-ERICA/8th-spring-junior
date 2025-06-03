package umc.study.service.memberService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodHandler;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.config.security.jwt.JwtTokenProvider;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberFoodConverter;
import umc.study.domain.Food;
import umc.study.domain.Member;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberFood;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.foodRepository.FoodRepository;
import umc.study.repository.memberMissionRepository.MemberMissionRepository;
import umc.study.repository.memberRepository.MemberRepository;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;
    private final MemberMissionRepository memberMissionRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;



    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member newMember = MemberConverter.toMember(request);
        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));

        List<Food> foodList = request.getPreferCategory().stream()
                .map(id -> foodRepository.findById(id)
                        .orElseThrow(() -> new FoodHandler(ErrorStatus.FOOD_NOT_FOUND)))
                .collect(Collectors.toList());

        List<MemberFood> memberFoodList = MemberFoodConverter.toMemberFoodList(foodList, newMember);

        memberFoodList.forEach(memberFood -> {memberFood.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    @Transactional
    public void completeMission(Long memberId, Long memberMissionId) {
        Member member = memberRepository.findById(memberId).get();  // 예외처리 없음
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId).get();

        // 상태가 IN_PROGRESS일 때만 COMPLETED로 바꿔줌
        if (memberMission.getMember().equals(member) &&
                memberMission.getStatus() == MissionStatus.IN_PROGRESS) {

            memberMission.updateStatus(MissionStatus.COMPLETED);
        }
    }

    @Override
    public MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        if(!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new MemberHandler(ErrorStatus.INVALID_PASSWORD);
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                member.getEmail(), null,
                Collections.singleton(() -> member.getRole().name())
        );

        String accessToken = jwtTokenProvider.generateToken(authentication);

        return MemberConverter.toLoginResultDTO(
                member.getId(),
                accessToken
        );
    }
}

