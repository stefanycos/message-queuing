package br.com.redis.spring.demo.subscriber;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageSubscriber implements MessageListener {

	@Override
	public void onMessage(Message message, byte[] pattern) {
		log.info("Received >> {} | {}", message, Thread.currentThread().getName());
	}

}
