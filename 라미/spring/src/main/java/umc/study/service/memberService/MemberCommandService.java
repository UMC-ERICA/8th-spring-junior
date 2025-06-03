package umc.study.service.memberService;

import umc.study.domain.Member;
import umc.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
    void completeMission(Long memberId, Long memberMissionId);
}
