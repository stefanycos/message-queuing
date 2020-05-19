package br.com.messaging.redis.demo.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.messaging.redis.demo.config.ConnectionFactory;
import redis.clients.jedis.Jedis;

public class DefaultMessagePublisher implements MessagePublisher {

	private static final Logger logger = LoggerFactory.getLogger(DefaultMessagePublisher.class);

	public void send(String channel, String message) {
		try {
			Jedis jedis = ConnectionFactory.getConnection();

			logger.info("Publishing message '{}' to channel '{}'", message, channel);
			jedis.publish(channel, message);

		} catch (final Exception e) {
			logger.error("Error on trying to publish message. Error: {}", e.getMessage());
		}
	}

}
