package com.umc.spring.service.memberMissionService;

import com.umc.spring.domain.enums.MemberMissionStatus;
import com.umc.spring.domain.mapping.MemberMission;
import com.umc.spring.repository.memberMissionRepository.MemberMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService{

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public List<MemberMission> findMissionsByStatus(Long memberId, MemberMissionStatus status) {
        return memberMissionRepository.findMissionByMemberIdAndStatus(memberId, status);
    }
}
