# Message Queuing Demos

Usage demonstrations of Message Queuing with RabbitMQ and Redis.

### Requirements
* Maven
* JDK 1.8

#### Applications Description
* **rabbitmq-demo:** implementation of a producer/consumer using [RabbitMQ Java client](https://www.rabbitmq.com/java-client.html) library.

* **rabbitmq-spring-demo:** implementation of a producer/consumer of RabbitMQ, making use of [Spring AMQP](https://spring.io/projects/spring-amqp).

* **jms-rabbitmq-spring-demo:** implementation of a producer/consumer using JMS API to communicate with RabbitMQ over AMQP Protocol, making use of [RabbitMQ JMS Client](https://www.rabbitmq.com/jms-client.html) and Spring Boot.

* **redis-subscriber-demo and redis-publisher-demo:** implementation of a producer/consumer using Redis as Message Broker, implemented with [Jedis Client](https://github.com/xetorthio/jedis) library.

* **redis-messaging-spring-demo:** implementation of a producer/consumer using Redis as Message Broker, implemented with [Sprint Data Redis](https://spring.io/projects/spring-data-redis).
