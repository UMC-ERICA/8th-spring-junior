package umc.study.service.storeService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.enums.StoreStatus;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);

    List<Store> findStoresByNameAndStatus(String name, StoreStatus status);

    Page<Review> getReviewList(Long StoreId, Integer page);

    Page<Mission> getMissionList(Long storeId, Integer page);
}
