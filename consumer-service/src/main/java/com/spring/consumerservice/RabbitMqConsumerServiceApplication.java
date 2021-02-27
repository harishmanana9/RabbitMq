package com.spring.consumerservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class RabbitMqConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqConsumerServiceApplication.class, args);
	}
}
