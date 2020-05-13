package br.com.rabbitmq.demo.consumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;

import br.com.rabbitmq.demo.config.ConfigurationProperties;
import br.com.rabbitmq.demo.config.RabbitMQConnectionFactory;

public class MessageConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

	private static final ConfigurationProperties properties = new ConfigurationProperties();

	private static final String QUEUE_PROPERTY = "app.queue.name";

	public void receiveMessages() {
		Channel channel = null;

		try {
			LOGGER.info("Receiving message from message broker.");

			channel = RabbitMQConnectionFactory.getConnection().createChannel();

			Consumer consumer = new MessageReceiver(channel);
			
			channel.basicConsume(getQueueName(), true, consumer);

		} catch (final IOException e) {
			LOGGER.error("Error on trying to receive message: {}", e.getMessage());
		} finally {
			try {
				if (channel != null) {
					channel.close();
				}
			} catch (final IOException e) {
				this.logErrorMessage(e);
			} catch (final TimeoutException e) {
				this.logErrorMessage(e);
			}
		}
	}

	private void logErrorMessage(Exception e) {
		LOGGER.error("An error occured when closing channel. Error: {}", e.getMessage());
	}

	private String getQueueName() {
		return properties.getProperty(QUEUE_PROPERTY);
	}

}
