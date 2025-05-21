package com.umc.spring.domain.mapping;

import com.umc.spring.domain.Food;
import com.umc.spring.domain.Member;
import com.umc.spring.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class MemberLikeFood extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    // setMember 워크북에 있어서 일단 만들어는 둠
    public void setMember(Member member) {
        if(this.member != null)
            member.getMemberLikeFoods().remove(this);
        this.member = member;
        member.getMemberLikeFoods().add(this);
    }

    public void setFood(Food food){
        this.food = food;
    }

}
