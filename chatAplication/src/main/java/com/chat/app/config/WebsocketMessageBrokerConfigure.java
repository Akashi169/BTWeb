package com.chat.app.config;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

public interface WebsocketMessageBrokerConfigure {
	void registerStompEndpoints(StompEndpointRegistry registry);
	void configureMessageBroker(MessageBrokerRegistry registry);
}
