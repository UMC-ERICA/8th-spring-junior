package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.study.validation.annotation.PageCheck;

public class PageValidator implements ConstraintValidator<PageCheck, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            int page = Integer.parseInt(value);
            return page >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

