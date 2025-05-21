package com.umc.spring.domain;

import com.umc.spring.domain.common.BaseEntity;
import com.umc.spring.domain.enums.Category;
import com.umc.spring.domain.imgs.RestImg;
import com.umc.spring.domain.mapping.MemberAgree;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@Getter
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(nullable = false, length = 50)
    private String restName;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(50)")
    private Category category;

    @ColumnDefault("0.0")
    private Float score;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Mission> missions = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<RestImg> restImgs = new ArrayList<>();

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", restname='" + restName + '\'' +
                ", address='" + region.getCityDo() + " " + region.getSiGunGu() + '\'' +
                '}';
    }

}
