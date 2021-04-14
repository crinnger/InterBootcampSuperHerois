package br.com.crinnger.InterBootcampSuperHerois;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterBootcampSuperHeroisApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterBootcampSuperHeroisApplication.class, args);
		System.out.println("super heroies com webflux");
	}

}
