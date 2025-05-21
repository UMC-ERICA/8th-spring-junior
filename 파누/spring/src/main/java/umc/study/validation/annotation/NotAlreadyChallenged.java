package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.AlreadyChallengedValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AlreadyChallengedValidator.class)
@Target({ ElementType.TYPE }) // DTO 전체를 검증 (여러 개가 엮인 것 같아서)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotAlreadyChallenged {
    String message() default "이미 도전 중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}