package umc.study.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Store;
import umc.study.domain.enums.StoreStatus;
import umc.study.repository.storeRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndStatus(String name, StoreStatus status) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, status);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }
}
