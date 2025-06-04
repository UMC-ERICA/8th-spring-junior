package com.umc.spring.repository.foodRepository;

import com.umc.spring.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
