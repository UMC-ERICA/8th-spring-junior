package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.Member;
import umc.study.domain.Food;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberFood extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    // 연관관계 편의 메서드 (Member 쪽)
    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getMemberFoodList().remove(this);
        }
        this.member = member;
        member.getMemberFoodList().add(this);
    }


    //연관관계 편의 메서드 (Food 쪽)
    public void setFood(Food food) {
        if (this.food != null) {
            this.food.getMemberFoodList().remove(this);
        }
        this.food = food;
        food.getMemberFoodList().add(this);
    }

}
