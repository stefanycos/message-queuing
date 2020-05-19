package br.com.messaging.redis.demo.subscriber.channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.JedisPubSub;

public class ChannelSubscriber extends JedisPubSub {

	private static final Logger logger = LoggerFactory.getLogger(ChannelSubscriber.class);

	@Override
	public void onMessage(String channel, String message) {
		logger.info("Message received '{}' from channel '{}'", message, channel);
	}

	@Override
	public void onSubscribe(String channel, int subscribedChannels) {
		logger.info("Client subscribed to channel '{}'", channel);
		logger.info("Total number of subscribed channels '{}'", subscribedChannels);
	}

}
