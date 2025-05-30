package com.umc.spring.validation.validator;

import com.umc.spring.apiPayload.code.status.ErrorStatus;
import com.umc.spring.dto.requestDto.AlreadyStartValidRequest;
import com.umc.spring.repository.memberMissionRepository.MemberMissionRepository;
import com.umc.spring.repository.missionRepository.MissionRepository;
import com.umc.spring.validation.annotation.AlreadyStart;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AlreadyStartValidator implements ConstraintValidator<AlreadyStart, AlreadyStartValidRequest> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(AlreadyStart constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AlreadyStartValidRequest request, ConstraintValidatorContext context) {
        Long memberId = request.getMemberId();
        boolean isValid = request.getMissionIds().stream()
                .allMatch(value -> memberMissionRepository.existsByMemberIdAndMissionId(memberId, value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
