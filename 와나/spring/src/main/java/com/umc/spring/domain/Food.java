package com.umc.spring.domain;

import com.umc.spring.domain.common.BaseEntity;
import com.umc.spring.domain.enums.Category;
import com.umc.spring.domain.mapping.MemberAgree;
import com.umc.spring.domain.mapping.MemberLikeFood;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Food extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false, length = 20)
    private Category foodName;


    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<MemberLikeFood> memberLikeFoods = new ArrayList<>();
}
