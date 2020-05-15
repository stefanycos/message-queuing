package br.com.rabbitmq.spring.demo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageListener {
	
	
	@RabbitListener(queues = "${app.queue-name}", ackMode = "AUTO")
	public void consumer(@Payload String message) {
		log.info("Message received '{}'", message);
	}
}
