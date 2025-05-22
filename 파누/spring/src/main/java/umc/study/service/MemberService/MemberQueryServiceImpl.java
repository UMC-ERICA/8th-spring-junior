package umc.study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.service.MemberService.MemberQueryService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    @Override
    public Member getMemberWithReviews(Long memberId) {
        /**
         * 흠 이건 어떤 메서드인지 잘 모르겠어요...!
         *
         * 회원 ID로 리뷰를 찾는건가? 그러면 반환이 리뷰여야 할 것 같은데 회원을 반환하고 있네요..!
         * 일단 제가 해석한건 회원을 ID로 찾ㅇㅏ서 반환하는건가 싶은데 흠
         * 일단 그렇게 해놓을게요 그게 쉽기도 해서 ㅋㅋㅋ
         * */
        return memberRepository.findById(memberId)
                .orElseThrow();
    }
}
