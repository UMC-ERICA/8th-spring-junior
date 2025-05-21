package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.RestaurantExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RestaurantExistValidator.class)
@Target({ ElementType.FIELD })  // 필드에만 사용
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsRestaurant {
    String message() default "해당 가게가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}