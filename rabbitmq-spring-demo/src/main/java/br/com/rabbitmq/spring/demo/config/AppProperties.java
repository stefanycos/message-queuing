package br.com.rabbitmq.spring.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Setter
@Getter
@ConfigurationProperties(prefix = "app")
public class AppProperties {

	private String exchangeName;

	private String queueName;

	private String routingKey;

}
