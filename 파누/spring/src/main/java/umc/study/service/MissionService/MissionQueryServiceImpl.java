package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.repository.MissionRepository.MissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public void getMissionsByLocation(String location) {

        /**
         * 이것도 아마 쿼리DSL에서 로케이션으로 미션을 찾는 메서드를 만드려고 헀던 것 같은데
         * 이건 메서드 하나로는 원래 해결되지 않는 로직이라
         *
         * 일단 주석처리 할게요...!
         * */
        /*return missionRepository.findMissionByLocation(location);*/
    }
}
