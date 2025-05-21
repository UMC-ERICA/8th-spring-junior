package com.umc.spring.validation.annotation;

import com.umc.spring.validation.validator.AlreadyStartValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AlreadyStartValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface AlreadyStart {

    String message() default "이미 시작된 미션입니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
