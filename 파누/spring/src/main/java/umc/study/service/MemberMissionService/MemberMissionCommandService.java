package umc.study.service.MemberMissionService;

import umc.study.web.dto.MemberMissionDTO.MemberMissionRequestDTO;
import umc.study.web.dto.MemberMissionDTO.MemberMissionResponseDTO;

public interface MemberMissionCommandService {
    MemberMissionResponseDTO.JoinMissionResult joinMission(MemberMissionRequestDTO.JoinMission request);
}