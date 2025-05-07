package com.umc.spring.domain.imgs;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRestImg is a Querydsl query type for RestImg
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestImg extends EntityPathBase<RestImg> {

    private static final long serialVersionUID = -79195926L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRestImg restImg = new QRestImg("restImg");

    public final com.umc.spring.domain.common.QBaseEntity _super = new com.umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgUrl = createString("imgUrl");

    public final com.umc.spring.domain.QRestaurant restaurant;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QRestImg(String variable) {
        this(RestImg.class, forVariable(variable), INITS);
    }

    public QRestImg(Path<? extends RestImg> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRestImg(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRestImg(PathMetadata metadata, PathInits inits) {
        this(RestImg.class, metadata, inits);
    }

    public QRestImg(Class<? extends RestImg> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new com.umc.spring.domain.QRestaurant(forProperty("restaurant"), inits.get("restaurant")) : null;
    }

}

