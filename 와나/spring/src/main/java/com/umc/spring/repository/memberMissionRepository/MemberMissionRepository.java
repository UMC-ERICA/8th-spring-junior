package com.umc.spring.repository.memberMissionRepository;

import com.umc.spring.domain.Member;
import com.umc.spring.domain.Mission;
import com.umc.spring.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {
    Page<MemberMission> findAllByMember(Member member, PageRequest pageRequest);

    MemberMission findByMemberAndMission(Member member, Mission mission);

    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);

}
