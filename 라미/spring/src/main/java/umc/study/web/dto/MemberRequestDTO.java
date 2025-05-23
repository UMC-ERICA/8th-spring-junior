package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import umc.study.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDto {
        @NotBlank
        String name;
        Integer gender;
        LocalDate birth;
        String address;
        String email;
        @ExistCategories
        List<Long> preferCategory;

    }
}
