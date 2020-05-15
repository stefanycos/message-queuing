package br.com.rabbitmq.spring.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConsumerConfiguration {

	@Autowired
	private AppProperties properties;

	@Bean
	public Queue declareQueue() { //@formatter:off
		return QueueBuilder.durable(properties.getQueueName())
				.build();
	} 

	@Bean
	public Binding declareBinding(Exchange exchange, Queue queue) {
		return BindingBuilder.bind(queue)
				.to(exchange)
				.with(properties.getRoutingKey())
				.noargs();
	} //@formatter:on
}
