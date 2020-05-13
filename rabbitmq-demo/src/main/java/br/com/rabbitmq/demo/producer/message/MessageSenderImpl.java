package br.com.rabbitmq.demo.producer.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.rabbitmq.demo.producer.MessageProducer;

public class MessageSenderImpl implements MessageSender {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageSenderImpl.class);

	private static final MessageProducer producer = new MessageProducer();

	public void send(String message) {
		LOGGER.info("Starting send messages...");
		
		for (int i = 1; i <= 10; i++) {
			producer.sendMessage("Message " + i + " - " + message);
		}
	}

}
