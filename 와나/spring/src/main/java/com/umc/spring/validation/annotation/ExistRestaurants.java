package com.umc.spring.validation.annotation;

import com.umc.spring.validation.validator.AlreadyStartValidator;
import com.umc.spring.validation.validator.ExistRestaurantsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistRestaurantsValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistRestaurants {

    String message() default "존재하지 않는 레스토랑입니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
