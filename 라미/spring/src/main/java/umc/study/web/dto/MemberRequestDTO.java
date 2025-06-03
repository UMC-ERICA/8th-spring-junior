package umc.study.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import umc.study.domain.enums.Role;
import umc.study.validation.annotation.ExistCategories;

import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {
    @Getter
    @Setter
    public static class JoinDto {
        @NotBlank
        String name;
        Integer gender;
        LocalDate birth;
        String address;
        @Email
        String email;
        @NotBlank
        String password;
        @ExistCategories
        List<Long> preferCategory;
        @NotNull
        Role role;

    }
}
