package umc.study.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.repository.storeRepository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public StoreResponseDTO.StoreIdResult createStore(StoreRequestDTO.CreateStore request) {
        Store store = StoreConverter.toEntity(request);
        Store saved = storeRepository.save(store);
        return StoreConverter.toStoreIdResult(saved);
    }
}
