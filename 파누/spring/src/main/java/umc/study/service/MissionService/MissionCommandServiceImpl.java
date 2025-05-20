package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.domain.Restaurant;
import umc.study.web.dto.MissionDTO.MissionRequestDTO;
import umc.study.web.dto.MissionDTO.MissionResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public MissionResponseDTO.AddMissionResult addMission(MissionRequestDTO.AddMission request) {
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new IllegalArgumentException("해당 가게를 찾을 수 없습니다."));

        Mission mission = Mission.builder()
                .restaurant(restaurant)
                .build();

        Mission saved = missionRepository.save(mission);
        return new MissionResponseDTO.AddMissionResult(saved.getId(), "미션 등록 완료");
    }
}
