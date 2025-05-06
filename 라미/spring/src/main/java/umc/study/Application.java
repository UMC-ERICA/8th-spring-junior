package umc.study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import umc.study.domain.enums.StoreStatus;
import umc.study.service.StoreService.StoreQueryService;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			StoreQueryService storeService = context.getBean(StoreQueryService.class);

			// 파라미터 값 설정
			String name = "요아정";
			StoreStatus status = StoreStatus.OPEN;

			// 쿼리 메서드 호출 및 파라미터 출력
			System.out.println("Executing findStoresByNameAndStatus with parameters:");
			System.out.println("Name: " + name);
			System.out.println("Status: " + status);

			storeService.findStoresByNameAndStatus(name, status)
					.forEach(System.out::println);

		};
	}
}
