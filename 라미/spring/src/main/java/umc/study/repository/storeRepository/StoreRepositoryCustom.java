package umc.study.repository.storeRepository;

import umc.study.domain.Store;
import umc.study.domain.enums.StoreStatus;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, StoreStatus status);
}
