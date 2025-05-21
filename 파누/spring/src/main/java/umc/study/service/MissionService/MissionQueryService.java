package umc.study.service.MissionService;

import umc.study.domain.Mission;

import java.util.List;

public interface MissionQueryService {
    List<Mission> getMissionsByLocation(String location);
}
