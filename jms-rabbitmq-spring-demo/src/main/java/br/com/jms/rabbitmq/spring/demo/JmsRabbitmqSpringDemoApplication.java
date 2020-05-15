package br.com.jms.rabbitmq.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableJms
@SpringBootApplication
public class JmsRabbitmqSpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmsRabbitmqSpringDemoApplication.class, args);
	}

}
