package com.spring.producerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.producerservice.domain.User;
import com.spring.producerservice.service.RabbitMqSender;

@RestController
@RequestMapping(value="/api/v1")
public class ProducerController {

	private RabbitMqSender rabbitMqSender;
	
	@Autowired
	public ProducerController(RabbitMqSender sender) {
		rabbitMqSender = sender;
	}
	
	@Value("${app.message}")
	private String message;
	
	@PostMapping("/user")
	public String publishUserDetails(@RequestBody User userObj) {
		rabbitMqSender.send(userObj);
		return message;
	}
}
