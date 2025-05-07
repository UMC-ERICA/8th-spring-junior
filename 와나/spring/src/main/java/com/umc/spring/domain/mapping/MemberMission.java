package com.umc.spring.domain.mapping;

import com.umc.spring.domain.Member;
import com.umc.spring.domain.Mission;
import com.umc.spring.domain.common.BaseEntity;
import com.umc.spring.domain.enums.MemberMissionStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Column(nullable = false)
    @ColumnDefault("'PROGRESS'")
    @Enumerated(EnumType.STRING)
    private MemberMissionStatus status;

}
