package br.com.jms.rabbitmq.spring.demo.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageListener {

	@JmsListener(destination = "${app.queue-name}")
	public void onMessageReceive(@Payload String message) {
		log.info("Message Received '{}'", message);
	}

}
