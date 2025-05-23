package umc.study.converter;

import umc.study.domain.Store;
import umc.study.domain.enums.StoreStatus;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public class StoreConverter {

    public static Store toEntity(StoreRequestDTO.CreateStore request) {
        return Store.builder()
                .name(request.getName())
                .phone("000-0000-0000") // 기본값 또는 랜덤 처리, 현재 구조상 필요
                .status(StoreStatus.OPEN)
                .build();
    }

    public static StoreResponseDTO.StoreIdResult toStoreIdResult(Store store) {
        return StoreResponseDTO.StoreIdResult.builder()
                .storeId(store.getId())
                .build();
    }
}

