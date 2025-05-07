package umc.study.service.storeService;

import umc.study.domain.Store;
import umc.study.domain.enums.StoreStatus;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);

    List<Store> findStoresByNameAndStatus(String name, StoreStatus status);
}
