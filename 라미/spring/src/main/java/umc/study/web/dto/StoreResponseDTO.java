package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

public class StoreResponseDTO {
    @Getter
    @Builder
    public static class StoreIdResult {
        private Long storeId;
    }
}
