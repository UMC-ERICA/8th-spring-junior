package umc.study.web.dto;

import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class CreateStore {
        private String name;
        private String address; // 지역 포함 주소 전체
    }
}
