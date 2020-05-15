package br.com.rabbitmq.spring.demo.producer;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.rabbitmq.spring.demo.config.AppProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class DefaultMessageSender implements MessageSender {

	private final RabbitTemplate rabbitTemplate;

	private final AppProperties properties;

	@Scheduled(initialDelay = 3000, fixedRate = 6000)
	@Override
	public void send() {
		String message = "RabbitMQ Message Demo - " + LocalDateTime.now().toString();

		log.info("Sending message '{}' to RabbitMQ.", message);

		rabbitTemplate.convertAndSend(properties.getExchangeName(), properties.getRoutingKey(), message);
	}

}
