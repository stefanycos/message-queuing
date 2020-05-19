package br.com.messaging.redis.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;

public class ConnectionFactory {

	private static final Logger logger = LoggerFactory.getLogger(ConnectionFactory.class);

	private static Jedis jedis = null;

	public static Jedis getConnection() {

		if (jedis == null) {
			jedis = new Jedis();
		}

		logger.info("New connection with Redis create {}", jedis);
		return jedis;
	}

	public static void closeConnection() {
		logger.info("Closing connection with Redis...");
		jedis.close();
	}

}
