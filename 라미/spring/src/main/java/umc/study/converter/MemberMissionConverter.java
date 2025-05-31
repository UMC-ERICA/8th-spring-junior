package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.Member;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberMissionResponseDTO;

// MemberMissionConverter.java
public class MemberMissionConverter {
    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.IN_PROGRESS)
                .build();
    }

    public static MemberMissionResponseDTO.ChallengeResult toChallengeResult(MemberMission memberMission) {
        return MemberMissionResponseDTO.ChallengeResult.builder()
                .memberMissionId(memberMission.getId())
                .status(memberMission.getStatus())
                .build();
    }
}
