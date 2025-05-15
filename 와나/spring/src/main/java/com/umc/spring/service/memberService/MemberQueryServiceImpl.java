package com.umc.spring.service.memberService;

import com.umc.spring.domain.Member;
import com.umc.spring.repository.memberRepository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;

    @Override
    public Member findMemberById(Long memberId) {
        return memberRepository.findMemberById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 사용자가 없습니다. memberId = " + memberId));
    }
}
