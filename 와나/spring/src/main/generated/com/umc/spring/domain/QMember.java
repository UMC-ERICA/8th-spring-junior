package com.umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -693341677L;

    public static final QMember member = new QMember("member1");

    public final com.umc.spring.domain.common.QBaseEntity _super = new com.umc.spring.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<com.umc.spring.domain.enums.Gender> gender = createEnum("gender", com.umc.spring.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.umc.spring.domain.mapping.MemberAgree, com.umc.spring.domain.mapping.QMemberAgree> memberAgrees = this.<com.umc.spring.domain.mapping.MemberAgree, com.umc.spring.domain.mapping.QMemberAgree>createList("memberAgrees", com.umc.spring.domain.mapping.MemberAgree.class, com.umc.spring.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<com.umc.spring.domain.mapping.MemberLikeFood, com.umc.spring.domain.mapping.QMemberLikeFood> memberLikeFoods = this.<com.umc.spring.domain.mapping.MemberLikeFood, com.umc.spring.domain.mapping.QMemberLikeFood>createList("memberLikeFoods", com.umc.spring.domain.mapping.MemberLikeFood.class, com.umc.spring.domain.mapping.QMemberLikeFood.class, PathInits.DIRECT2);

    public final ListPath<com.umc.spring.domain.mapping.MemberMission, com.umc.spring.domain.mapping.QMemberMission> memberMissions = this.<com.umc.spring.domain.mapping.MemberMission, com.umc.spring.domain.mapping.QMemberMission>createList("memberMissions", com.umc.spring.domain.mapping.MemberMission.class, com.umc.spring.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final NumberPath<Long> point = createNumber("point", Long.class);

    public final StringPath refreshToken = createString("refreshToken");

    public final ListPath<Review, QReview> reviews = this.<Review, QReview>createList("reviews", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<com.umc.spring.domain.enums.SocialType> socialType = createEnum("socialType", com.umc.spring.domain.enums.SocialType.class);

    public final EnumPath<com.umc.spring.domain.enums.MemberStatus> status = createEnum("status", com.umc.spring.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath username = createString("username");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

