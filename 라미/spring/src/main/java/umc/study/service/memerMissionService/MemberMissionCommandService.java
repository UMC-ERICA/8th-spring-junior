package umc.study.service.memerMissionService;

import umc.study.web.dto.MemberMissionRequestDTO;
import umc.study.web.dto.MemberMissionResponseDTO;

public interface MemberMissionCommandService {
    MemberMissionResponseDTO.ChallengeResult challengeMission(Long storeId, Long missionId, MemberMissionRequestDTO.ChallengeRequest request);
}
