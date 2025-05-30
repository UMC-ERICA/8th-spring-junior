package com.umc.spring.validation.validator;

import com.umc.spring.apiPayload.code.status.ErrorStatus;
import com.umc.spring.repository.restaurantRepository.RestaurantRepository;
import com.umc.spring.validation.annotation.ExistRestaurants;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ExistRestaurantsValidator implements ConstraintValidator<ExistRestaurants, List<Long>> {

    private final RestaurantRepository restaurantRepository;

    @Override
    public void initialize(ExistRestaurants constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> restaurantRepository.existsById(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
