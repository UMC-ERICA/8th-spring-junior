package umc.study.converter;

import umc.study.domain.Food;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberFood;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MemberFoodConverter {
    public static List<MemberFood> toMemberFoodList(List<Food> foodList, Member member) {
        return foodList.stream()
                .filter(Objects::nonNull) // food가 null인 경우 방지
                .map(food -> {
                    MemberFood mf = MemberFood.builder()
                            .food(food)
                            .build();

                    // 양방향 연관관계 메서드 직접 호출
                    mf.setMember(member);
                    mf.setFood(food);

                    return mf;
                })
                .collect(Collectors.toList());
    }
}
