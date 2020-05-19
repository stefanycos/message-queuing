package br.com.messaging.redis.demo.subscriber;

public interface MessageSubscriber {

	void subscribe(String... channels);
}
