package br.com.rabbitmq.spring.demo.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQProducerConfiguration {

	@Bean
	public Exchange declareExchange(AppProperties properties) { //@formatter:off
		return ExchangeBuilder.directExchange(properties.getExchangeName())
							  .durable(true)
							  .build();
	}
	
}
