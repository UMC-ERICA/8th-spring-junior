package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.repository.RestaurantRepository.RestaurantRepository;
import umc.study.validation.annotation.ExistsRestaurant;

@Component
@RequiredArgsConstructor
public class RestaurantExistValidator implements ConstraintValidator<ExistsRestaurant, Long> {

    private final RestaurantRepository restaurantRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) return false;
        return restaurantRepository.existsById(value);
    }
}