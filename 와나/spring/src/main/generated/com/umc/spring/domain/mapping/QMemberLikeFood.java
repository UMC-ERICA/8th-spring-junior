package com.umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberLikeFood is a Querydsl query type for MemberLikeFood
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberLikeFood extends EntityPathBase<MemberLikeFood> {

    private static final long serialVersionUID = -402341912L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberLikeFood memberLikeFood = new QMemberLikeFood("memberLikeFood");

    public final com.umc.spring.domain.common.QBaseEntity _super = new com.umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final com.umc.spring.domain.QFood food;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.umc.spring.domain.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMemberLikeFood(String variable) {
        this(MemberLikeFood.class, forVariable(variable), INITS);
    }

    public QMemberLikeFood(Path<? extends MemberLikeFood> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberLikeFood(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberLikeFood(PathMetadata metadata, PathInits inits) {
        this(MemberLikeFood.class, metadata, inits);
    }

    public QMemberLikeFood(Class<? extends MemberLikeFood> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.food = inits.isInitialized("food") ? new com.umc.spring.domain.QFood(forProperty("food")) : null;
        this.member = inits.isInitialized("member") ? new com.umc.spring.domain.QMember(forProperty("member")) : null;
    }

}

