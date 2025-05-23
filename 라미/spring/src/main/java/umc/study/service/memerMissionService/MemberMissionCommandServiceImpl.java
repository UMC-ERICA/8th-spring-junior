package umc.study.service.memerMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.memberMissionRepository.MemberMissionRepository;
import umc.study.repository.memberRepository.MemberRepository;
import umc.study.repository.missionRepository.MissionRepository;
import umc.study.web.dto.MemberMissionRequestDTO;
import umc.study.web.dto.MemberMissionResponseDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public MemberMissionResponseDTO.ChallengeResult challengeMission(Long storeId, Long missionId, MemberMissionRequestDTO.ChallengeRequest request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission memberMission = MemberMissionConverter.toMemberMission(member, mission);
        memberMissionRepository.save(memberMission);

        return MemberMissionConverter.toChallengeResult(memberMission);
    }
}
