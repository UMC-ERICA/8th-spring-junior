package com.umc.spring;

import com.umc.spring.service.RestaurantService.RestaurantQueryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			RestaurantQueryService restService = context.getBean(RestaurantQueryService.class);

			// 파라미터 값 설정
			String restname = "요아정";
			Float score = 4.0f;

			// 쿼리 메소드 호출 및 쿼리 문자열과 파라미터 출력
			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
			System.out.println("Executing findStoresByNameAndScore with parameters:");
			System.out.println("Name: " + restname);
			System.out.println("Score: " + score);

			restService.findRestaurantsByNameAndScore(restname, score)
					.forEach(System.out::println);
		};
	}
}
