package com.umc.spring.domain.mapping;

import com.umc.spring.domain.Member;
import com.umc.spring.domain.Terms;
import com.umc.spring.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class MemberAgree extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private Boolean isAgree;

    @ManyToOne
    @JoinColumn(name = "terms_idx")
    private Terms terms;

    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;

}
