package com.umc.spring.domain.enums;

import java.util.Arrays;

public enum Category {
    KOREAN_FOOD(1), JAPANESE_FOOD(2), CHINESE_FOOD(3), AMERICAN_FOOD(4),
    CHICKEN(5), SNACK_FOOD(6), GRILL(7), LUNCH_BOX(8),
    MIDNIGHT_SNACK(9), FAST_FOOD(10), DESSERT(11), ASIAN_FOOD(12);

    private final int code;

    Category(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Category fromCode(int code) {
        return Arrays.stream(values())
                .filter(c -> c.code == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid category code: " + code));
    }
}
