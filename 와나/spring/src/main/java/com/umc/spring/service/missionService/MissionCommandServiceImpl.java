package com.umc.spring.service.missionService;

import com.umc.spring.apiPayload.code.status.ErrorStatus;
import com.umc.spring.apiPayload.exception.handler.ErrorHandler;
import com.umc.spring.convert.MissionConverter;
import com.umc.spring.domain.Member;
import com.umc.spring.domain.Mission;
import com.umc.spring.domain.Restaurant;
import com.umc.spring.domain.mapping.MemberMission;
import com.umc.spring.dto.requestDto.MissionRequestDto;
import com.umc.spring.repository.memberMissionRepository.MemberMissionRepository;
import com.umc.spring.repository.memberRepository.MemberRepository;
import com.umc.spring.repository.missionRepository.MissionRepository;
import com.umc.spring.repository.restaurantRepository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

import static com.umc.spring.dto.requestDto.MissionRequestDto.*;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;

    private final RestaurantRepository restaurantRepository;

    private final MemberRepository memberRepository;

    private final MemberMissionRepository memberMissionRepository;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom random = new SecureRandom();

    private static final int CODE_LENGTH = 8;

    @Override
    public Mission createMission(MissionCreateDto request, Long restId) {
        Restaurant restaurant = restaurantRepository.findById(restId)
                .orElseThrow(() -> new ErrorHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        String certifiedNum = generateCode(CODE_LENGTH);

        Mission mission = MissionConverter.toMission(request, certifiedNum, restaurant);

        return missionRepository.save(mission);
    }

    @Override
    public Long startMission(Long missionId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new ErrorHandler(ErrorStatus.MISSION_NOT_FOUND));

        Member member = memberRepository.findMemberById(1L)
                .orElseThrow(() -> new ErrorHandler(ErrorStatus.MEMBER_NOT_FOUND));

        MemberMission memberMission = MemberMission.builder()
                .mission(mission)
                .member(member)
                .build();

        return memberMissionRepository.save(memberMission).getId();
    }

    private static String generateCode(int length) {
        StringBuilder code = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            code.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return code.toString();
    }
}
