package br.com.messaging.redis.demo.subscriber.channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.JedisPubSub;

public class ChannelPatternSubscriber extends JedisPubSub {

	private static final Logger logger = LoggerFactory.getLogger(ChannelPatternSubscriber.class);

	@Override
	public void onPMessage(String pattern, String channel, String message) {
		logger.info("Message received '{}' from channel '{}' with pattern '{}'", message, channel, pattern);
	}

	@Override
	public void onPSubscribe(String pattern, int subscribedChannels) {
		logger.info("Client subscribed to channel with pattern '{}'", pattern);
	}
}
