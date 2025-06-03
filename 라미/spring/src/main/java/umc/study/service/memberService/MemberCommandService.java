package umc.study.service.memberService;

import umc.study.domain.Member;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
    void completeMission(Long memberId, Long memberMissionId);
    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);
}
