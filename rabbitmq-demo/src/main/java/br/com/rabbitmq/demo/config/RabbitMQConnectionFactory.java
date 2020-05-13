package br.com.rabbitmq.demo.config;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQConnectionFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConnectionFactory.class);

	private static final ConfigurationProperties properties = new ConfigurationProperties();

	private static Connection connection;

	private static final String HOST_PROPERTY = "app.host";

	public static Connection getConnection() {
		if (connection == null) {

			try {

				ConnectionFactory factory = new ConnectionFactory();
				factory.setHost(getHost());
				connection = factory.newConnection();

			} catch (final IOException e) {
				logError(e);
			} catch (final TimeoutException e) {
				logError(e);
			}
		}

		return connection;
	}

	public static void closeConnection() {
		LOGGER.info("Closing RabbitMQ connection.");

		try {
			connection.close();
		} catch (final IOException e) {
			LOGGER.error("An error occured when closing connection. Error: {}", e.getMessage());
		}
	}

	private static void logError(final Exception e) {
		LOGGER.error("Erron on trying to create Connection: {}", e.getMessage());
	}

	private static String getHost() {
		return properties.getProperty(HOST_PROPERTY);
	}

}
