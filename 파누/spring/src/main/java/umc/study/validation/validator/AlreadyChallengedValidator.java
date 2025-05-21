package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.validation.annotation.NotAlreadyChallenged;
import umc.study.web.dto.MemberMissionDTO.MemberMissionRequestDTO;

@Component
@RequiredArgsConstructor
public class AlreadyChallengedValidator implements ConstraintValidator<NotAlreadyChallenged, MemberMissionRequestDTO.JoinMission> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(MemberMissionRequestDTO.JoinMission value, ConstraintValidatorContext context) {
        if (value == null || value.getMemberId() == null || value.getMissionId() == null) return false;

        return !memberMissionRepository.existsByMemberIdAndMissionId(value.getMemberId(), value.getMissionId());
    }
}
