package com.umc.spring.domain;

import com.umc.spring.domain.common.BaseEntity;
import com.umc.spring.domain.enums.AccMethod;
import com.umc.spring.domain.enums.MissionStatus;
import com.umc.spring.domain.mapping.MemberMission;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_idx")
    private Restaurant restaurant;

    @Column(nullable = false, length = 100)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(10) DEFAULT 'PROGRESS'")
    private MissionStatus status;

    @Column(nullable = false)
    private int successPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccMethod accMethod;

    @ColumnDefault("0")
    private int accPoint;

    private LocalDateTime deadline;

    @Column(nullable = false, length = 15)
    private String certifiedNum;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissions = new ArrayList<>();

}
