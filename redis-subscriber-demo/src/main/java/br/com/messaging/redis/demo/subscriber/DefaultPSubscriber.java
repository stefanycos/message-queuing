package br.com.messaging.redis.demo.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.messaging.redis.demo.config.ConnectionFactory;
import br.com.messaging.redis.demo.subscriber.channel.ChannelPatternSubscriber;
import redis.clients.jedis.Jedis;

public class DefaultPSubscriber implements MessageSubscriber {

	private static final Logger logger = LoggerFactory.getLogger(DefaultPSubscriber.class);

	public void subscribe(String... channels) {
		try {

			Jedis jedis = ConnectionFactory.createNewConnection();

			new Thread(new Runnable() {

				@Override
				public void run() {
					jedis.psubscribe(new ChannelPatternSubscriber(), channels);
				}
				
			}).start();

		} catch (final Exception e) {
			logger.error("Error on trying to subscribe. Error: {}", e.getMessage());
		}
	}

}
