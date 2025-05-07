package com.umc.spring.service.missionService;

import com.umc.spring.domain.Mission;
import com.umc.spring.domain.Region;
import com.umc.spring.repository.missionRepository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public List<Mission> findMissionsByRegionAndStatus(Region region) {
        return missionRepository.findMissionsByRegionAndStatus(region);
    }
}
