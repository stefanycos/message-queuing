package br.com.rabbitmq.demo.producer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Channel;

import br.com.rabbitmq.demo.config.ConfigurationProperties;
import br.com.rabbitmq.demo.config.RabbitMQConnectionFactory;

public class MessageProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageProducer.class);

	private static final ConfigurationProperties properties = new ConfigurationProperties();

	private static final String EXCHANGE_PROPERTY = "app.exchange.name";

	public void sendMessage(String message) {
		Channel channel = null;

		try {
			LOGGER.info("Sending message to message broker.");

			String exchange = this.getExchangeName();
			channel = RabbitMQConnectionFactory.getConnection().createChannel();
			channel.exchangeDeclare(exchange, "fanout");

			channel.basicPublish(exchange, "", null, message.getBytes());
			
			LOGGER.info("Message was sent successfully!");

		} catch (final IOException e) {
			LOGGER.error("Error on trying to send message: {}", e.getMessage());
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

	private String getExchangeName() {
		return properties.getProperty(EXCHANGE_PROPERTY);
	}

}
