package br.com.redis.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RedisSpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisSpringDemoApplication.class, args);
	}

}
