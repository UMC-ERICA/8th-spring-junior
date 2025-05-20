package umc.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.web.dto.MemberMissionDTO.MemberMissionRequestDTO;
import umc.study.web.dto.MemberMissionDTO.MemberMissionResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMissionResponseDTO.JoinMissionResult joinMission(MemberMissionRequestDTO.JoinMission request) {
        Member member = memberRepository.findAll().get(0); // 하드코딩된 회원

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("해당 미션 없음"));

        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.IN_PROGRESS)
                .build();

        MemberMission saved = memberMissionRepository.save(memberMission);

        return new MemberMissionResponseDTO.JoinMissionResult(saved.getId(), "미션 도전 성공!");
    }
}