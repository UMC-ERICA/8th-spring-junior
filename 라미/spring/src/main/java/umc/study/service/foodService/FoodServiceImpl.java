package umc.study.service.foodService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.repository.foodRepository.FoodRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean allExist(List<Long> ids) {
        if (ids == null || ids.isEmpty()) return true;
        return ids.stream()
                .allMatch(foodRepository::existsById);
    }
}
