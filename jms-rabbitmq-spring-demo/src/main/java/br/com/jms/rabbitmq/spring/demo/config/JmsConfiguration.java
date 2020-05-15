package br.com.jms.rabbitmq.spring.demo.config;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import com.rabbitmq.jms.admin.RMQConnectionFactory;

@Configuration
public class JmsConfiguration {

	@Autowired
	private AppProperties properties;

	@Bean
	public ConnectionFactory connectionFactory() {

		RMQConnectionFactory connectionFactory = new RMQConnectionFactory();
		connectionFactory.setHost(properties.getJms().getHost());
		connectionFactory.setVirtualHost(properties.getJms().getVirtualHost());
		connectionFactory.setPort(properties.getJms().getPort());
		connectionFactory.setUsername(properties.getJms().getUsername());
		connectionFactory.setPassword(properties.getJms().getPassword());

		return connectionFactory;
	}

	@Bean
	public JmsTemplate jmsTempate() {
		return new JmsTemplate(connectionFactory());
	}

}
