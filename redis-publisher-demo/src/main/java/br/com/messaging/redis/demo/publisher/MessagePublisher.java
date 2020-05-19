package br.com.messaging.redis.demo.publisher;

public interface MessagePublisher {

	void send(String channel, String message);

}
