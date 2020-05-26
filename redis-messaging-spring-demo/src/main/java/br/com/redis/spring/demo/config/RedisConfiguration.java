package br.com.redis.spring.demo.config;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import br.com.redis.spring.demo.subscriber.MessageSubscriber;

@Configuration
public class RedisConfiguration {

	@Bean
	public JedisConnectionFactory connectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();

		template.setConnectionFactory(connectionFactory());
		template.setValueSerializer(new StringRedisSerializer());

		return template;
	}

	@Bean
	public RedisMessageListenerContainer redisContainer() {
		final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		
		container.setConnectionFactory(connectionFactory());
		container.addMessageListener(new MessageSubscriber(), topic());
		container.setTaskExecutor(Executors.newFixedThreadPool(4));

		return container;
	}

	@Bean
	public ChannelTopic topic() {
		return new ChannelTopic("pubsub:channel-1");
	}
}
