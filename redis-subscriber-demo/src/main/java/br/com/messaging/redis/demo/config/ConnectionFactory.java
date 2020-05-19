package br.com.messaging.redis.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class ConnectionFactory {

	private static final Logger logger = LoggerFactory.getLogger(ConnectionFactory.class);

	private static final JedisPoolConfig poolConfig = new JedisPoolConfig();

	private static final JedisPool jedisPool = new JedisPool(poolConfig, "localhost");

	public static Jedis createNewConnection() {
		Jedis jedis = jedisPool.getResource();

		logger.info("New connection with Redis create {}", jedis);
		return jedis;
	}

	public static void closePoolConnection() {
		logger.info("Closing connection with Redis...");
		jedisPool.close();
	}
	
}
