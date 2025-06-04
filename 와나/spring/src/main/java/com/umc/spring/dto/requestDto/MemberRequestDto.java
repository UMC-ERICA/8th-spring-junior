package com.umc.spring.dto.requestDto;

import com.umc.spring.domain.enums.Role;
import com.umc.spring.validation.annotation.ExistCategories;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class MemberRequestDto {

    @Getter
    @Setter // thymeleaf
    public static class JoinDto {
        String name;
        String email;
        String password;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String addr;
        @ExistCategories
        List<Long> likeFoods;
        Role role;
    }

    @Getter
    @Setter
    public static class LoginRequestDto {
        @Email(message = "올바른 이메일 형식이어야 합니다.")
        private String email;

        @NotBlank(message = "패스워드는 필수입니다.")
        private String password;
    }
}
