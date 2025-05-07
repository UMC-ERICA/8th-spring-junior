package umc.study.service.memberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.repository.memberRepository.MemberRepository;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    @Override
    public void printMyPageInfo(Long memberId) {
        Member member = memberRepository.findMemberWithReviews(memberId);

        System.out.println("이름: " + member.getName());
        System.out.println("이메일: " + member.getEmail());
        System.out.println("포인트: " + member.getPoint());
        System.out.println("작성한 리뷰 수: " + member.getReviewList().size());
    }
}
