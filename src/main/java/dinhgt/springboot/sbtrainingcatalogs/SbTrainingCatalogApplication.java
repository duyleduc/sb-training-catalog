package dinhgt.springboot.sbtrainingcatalogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SbTrainingCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbTrainingCatalogApplication.class, args);
	}

}
