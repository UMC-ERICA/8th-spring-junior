package com.umc.spring.domain;

import com.umc.spring.domain.common.BaseEntity;
import com.umc.spring.domain.enums.Gender;
import com.umc.spring.domain.enums.MemberStatus;
import com.umc.spring.domain.enums.SocialType;
import com.umc.spring.domain.mapping.MemberAgree;
import com.umc.spring.domain.mapping.MemberLikeFood;
import com.umc.spring.domain.mapping.MemberMission;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Long point;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status; // 활성, 비활성

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String refreshToken;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgrees = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberLikeFood> memberLikeFoods = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissions = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

}
