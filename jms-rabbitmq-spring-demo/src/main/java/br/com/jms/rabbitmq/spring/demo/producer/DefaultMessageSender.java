package br.com.jms.rabbitmq.spring.demo.producer;

import java.time.LocalDateTime;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.jms.rabbitmq.spring.demo.config.AppProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Component
public class DefaultMessageSender implements MessageSender {

	private JmsTemplate jmsTemplate;

	private AppProperties properties;

	@Scheduled(initialDelay = 3000, fixedRate = 6000)
	@Override
	public void send() {
		String message = "Message Demo JMS with AMQP Protocol - " + LocalDateTime.now().toString();
		log.info("Sending message '{}' to RabbitMQ", message);
		jmsTemplate.convertAndSend(properties.getQueueName(), message);
	}

}
