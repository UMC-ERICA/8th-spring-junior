package com.umc.spring.service.foodService;

import com.umc.spring.repository.foodRepository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Transactional(readOnly = true)
    public boolean existAllFoodCategories(List<Long> foodId) {
        return foodId.stream()
                .allMatch(foodRepository::existsById);
    }
}
