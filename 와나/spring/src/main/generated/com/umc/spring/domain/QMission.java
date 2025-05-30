package com.umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMission is a Querydsl query type for Mission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMission extends EntityPathBase<Mission> {

    private static final long serialVersionUID = 101812531L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMission mission = new QMission("mission");

    public final com.umc.spring.domain.common.QBaseEntity _super = new com.umc.spring.domain.common.QBaseEntity(this);

    public final EnumPath<com.umc.spring.domain.enums.AccMethod> accMethod = createEnum("accMethod", com.umc.spring.domain.enums.AccMethod.class);

    public final NumberPath<Integer> accPoint = createNumber("accPoint", Integer.class);

    public final StringPath certifiedNum = createString("certifiedNum");

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DatePath<java.time.LocalDate> deadline = createDate("deadline", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.umc.spring.domain.mapping.MemberMission, com.umc.spring.domain.mapping.QMemberMission> memberMissions = this.<com.umc.spring.domain.mapping.MemberMission, com.umc.spring.domain.mapping.QMemberMission>createList("memberMissions", com.umc.spring.domain.mapping.MemberMission.class, com.umc.spring.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final QRestaurant restaurant;

    public final EnumPath<com.umc.spring.domain.enums.MissionStatus> status = createEnum("status", com.umc.spring.domain.enums.MissionStatus.class);

    public final NumberPath<Integer> successPrice = createNumber("successPrice", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMission(String variable) {
        this(Mission.class, forVariable(variable), INITS);
    }

    public QMission(Path<? extends Mission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMission(PathMetadata metadata, PathInits inits) {
        this(Mission.class, metadata, inits);
    }

    public QMission(Class<? extends Mission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new QRestaurant(forProperty("restaurant"), inits.get("restaurant")) : null;
    }

}

