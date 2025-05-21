package com.umc.spring.repository.memberMissionRepository;

import com.umc.spring.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {
    List<MemberMission> findAllByMemberId(Long memberId); // 홈화면에서 미션 개수 셀 때 사용

    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);

}
