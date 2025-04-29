package com.umc.spring.domain;

import com.umc.spring.domain.common.BaseEntity;
import com.umc.spring.domain.mapping.MemberAgree;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Region extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false, length = 10)
    private String cityDo;

    @Column(nullable = false, length = 10)
    private String siGunGu;

    @Column(nullable = false, length = 10)
    private String dong;

    @OneToOne(mappedBy = "region")
    private Restaurant restaurant;
}
