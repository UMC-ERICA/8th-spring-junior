package com.umc.spring.convert;

import com.umc.spring.domain.Food;
import com.umc.spring.domain.mapping.MemberLikeFood;

import java.util.List;
import java.util.stream.Collectors;

public class MemberLikeFoodConverter {

    public static List<MemberLikeFood> toMemberListFoodList(List<Food> foodCategoryList) {

        return foodCategoryList.stream()
                .map(food ->
                        MemberLikeFood.builder()
                                .food(food)
                                .build()
                ).collect(Collectors.toList());
        
    }
}
