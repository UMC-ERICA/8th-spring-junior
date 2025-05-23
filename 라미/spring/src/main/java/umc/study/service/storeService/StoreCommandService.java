package umc.study.service.storeService;

import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public interface StoreCommandService {
    StoreResponseDTO.StoreIdResult createStore(StoreRequestDTO.CreateStore request);
}
