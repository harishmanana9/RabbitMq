package com.spring.consumerservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;

import com.spring.consumerservice.domain.User;

@Component
public class RabbitMqReceiver implements RabbitListenerConfigurer {
	private static final Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
	}
	
	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void receiveMessage(User user) {
		logger.info("User details received - " + user);
	}
}