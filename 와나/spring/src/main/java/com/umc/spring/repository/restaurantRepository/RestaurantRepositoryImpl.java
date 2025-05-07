package com.umc.spring.repository.restaurantRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.spring.domain.QRestaurant;
import com.umc.spring.domain.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    private final QRestaurant restaurant = QRestaurant.restaurant;


    @Override
    public List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (name != null) {
            predicate.and(restaurant.restName.eq(name));
        }

        if (score != null) {
            predicate.and(restaurant.score.goe(4.0f));
        }

        return jpaQueryFactory
                .selectFrom(restaurant)
                .where(predicate)
                .fetch();

    }
}
