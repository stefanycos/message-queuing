package br.com.redis.spring.demo.publisher;

import java.time.LocalDateTime;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Component
public class DefaultMessagePublisher implements MessagePublisher {

	private RedisTemplate<String, Object> redisTemplate;

	private ChannelTopic topic;

	@Scheduled(initialDelay = 3000, fixedRate = 6000)
	public void publish() {
		String message = "Redis pub/sub demo - " + LocalDateTime.now().toString();

		log.info("Sending message '{}' to channel '{}'", message, topic.getTopic());
		redisTemplate.convertAndSend(topic.getTopic(), message);
	}

}
