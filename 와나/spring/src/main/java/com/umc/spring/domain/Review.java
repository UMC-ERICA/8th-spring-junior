package com.umc.spring.domain;

import com.umc.spring.domain.common.BaseEntity;
import com.umc.spring.domain.imgs.RestImg;
import com.umc.spring.domain.imgs.ReviewImg;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_id")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false)
    private Double score;

    @Column(length = 50)
    private String content;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewImg> reviewImgs = new ArrayList<>();
}
