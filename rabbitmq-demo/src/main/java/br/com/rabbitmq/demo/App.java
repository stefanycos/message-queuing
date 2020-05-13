package br.com.rabbitmq.demo;

import java.io.IOException;

import br.com.rabbitmq.demo.config.RabbitMQConnectionFactory;
import br.com.rabbitmq.demo.consumer.MessageConsumer;
import br.com.rabbitmq.demo.producer.message.MessageSender;
import br.com.rabbitmq.demo.producer.message.MessageSenderImpl;

public class App {

	public static void main(String[] args) throws IOException {

		MessageSender sender = new MessageSenderImpl();
		sender.send("Testing Message Produces");

		MessageConsumer consumer = new MessageConsumer();
		consumer.receiveMessages();

		System.in.read();

		RabbitMQConnectionFactory.closeConnection();
	}
}
