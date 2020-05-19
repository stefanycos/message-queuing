package br.com.messaging.redis.demo;

import java.io.IOException;

import br.com.messaging.redis.demo.subscriber.DefaultPSubscriber;
import br.com.messaging.redis.demo.subscriber.DefaultSubscriber;
import br.com.messaging.redis.demo.subscriber.MessageSubscriber;

public class AppRedisSubscriber {

	public static void main(String[] args) throws IOException {

		MessageSubscriber subscriber = new DefaultSubscriber();
		subscriber.subscribe("channel-1", "channel-2");

		MessageSubscriber psubscriber = new DefaultPSubscriber();
		psubscriber.subscribe("channel.redis*");

		System.in.read();
	}
}
