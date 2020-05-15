package br.com.jms.rabbitmq.spring.demo.config;

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

	private Jms jms;

	@Getter
	@Setter
	public static class Jms {

		private String host;

		private String virtualHost;

		private int port;

		private String password;

		private String username;
	}

}
