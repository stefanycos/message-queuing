package br.com.messaging.redis.demo;

import java.io.IOException;

import br.com.messaging.redis.demo.config.ConnectionFactory;
import br.com.messaging.redis.demo.publisher.DefaultMessagePublisher;
import br.com.messaging.redis.demo.publisher.MessagePublisher;

public class AppRedisPublisher {

	public static void main(String[] args) throws IOException {

		MessagePublisher publisher = new DefaultMessagePublisher();
		publisher.send("channel-1", "Sending message to channel C1");
		publisher.send("channel-2", "Sending message to channel C2");
		publisher.send("channel.redis.demo", "Sending message to channel channel.redis.demo");

		System.in.read();
		ConnectionFactory.closeConnection();
	}
}
