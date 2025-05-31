package umc.study.repository.foodRepository;

import org.springframework.data.repository.CrudRepository;
import umc.study.domain.Food;

public interface FoodRepository extends CrudRepository<Food, Long> {
}
