package br.com.rabbitmq.demo.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class MessageReceiver extends DefaultConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiver.class);

	public MessageReceiver(Channel channel) {
		super(channel);
	}

	@Override
	public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
			throws IOException {

		String message = new String(body, "UTF-8");
		LOGGER.info("Message Received '{}'", message);
	}

}
