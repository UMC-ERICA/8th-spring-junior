package umc.study.service.memberService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.config.security.jwt.JwtTokenProvider;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.memberMissionRepository.MemberMissionRepository;
import umc.study.repository.memberRepository.MemberRepository;
import umc.study.repository.reviewRepository.ReviewRepository;
import umc.study.web.dto.MemberResponseDTO;
import umc.study.converter.MemberConverter;


@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MemberMissionRepository memberMissionRepository;

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void printMyPageInfo(Long memberId) {
        Member member = memberRepository.findMemberWithReviews(memberId);

        System.out.println("이름: " + member.getName());
        System.out.println("이메일: " + member.getEmail());
        System.out.println("포인트: " + member.getPoint());
        System.out.println("작성한 리뷰 수: " + member.getReviewList().size());
    }

    @Override
    public Page<Review> getMyReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();  // 예외 처리 없이 .get() 사용
        return reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
    }

    @Override
    public Page<MemberMission> getInProgressMissions(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        return memberMissionRepository.findAllByMemberAndStatus(member, MissionStatus.IN_PROGRESS, PageRequest.of(page, 10));
    }

    @Override
    @Transactional(readOnly = true)
    public MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return MemberConverter.toMemberInfoDTO(member);
    }
}
