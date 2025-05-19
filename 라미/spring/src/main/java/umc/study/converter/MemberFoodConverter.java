package umc.study.converter;

import umc.study.domain.Food;
import umc.study.domain.mapping.MemberFood;

import java.util.List;
import java.util.stream.Collectors;

public class MemberFoodConverter {
    public static List<MemberFood> toMemberFoodList(List<Food> foodList) {
        return foodList.stream()
                .map(food -> MemberFood.builder()
                        .food(food)
                        .build())
                .collect(Collectors.toList());
    }
}
