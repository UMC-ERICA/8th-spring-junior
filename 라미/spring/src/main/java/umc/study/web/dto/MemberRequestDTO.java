package umc.study.web.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDto {
        String name;
        Integer gender;
        LocalDate birth;
        String address;
        String email;
        List<Long> preferCategory;

    }
}
