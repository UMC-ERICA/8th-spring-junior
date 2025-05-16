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
        return memberRepository.findWithReviews(memberId);
    }
}
