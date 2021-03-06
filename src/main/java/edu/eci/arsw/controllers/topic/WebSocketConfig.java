/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.controllers.topic;

/**
 *
 * @author hcadavid
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableStompBrokerRelay("/topic/").setRelayHost("elephant.rmq.cloudamqp.com").setRelayPort(61613).
                setClientLogin("mihjhxnb").
                setClientPasscode("GQIrTPdPtIRa7d7SohDdw0Caj-EW8LP3").
                setSystemLogin("mihjhxnb").
                setSystemPasscode("GQIrTPdPtIRa7d7SohDdw0Caj-EW8LP3").
                setVirtualHost("mihjhxnb");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stompApple").setAllowedOrigins("*").withSockJS();

    }

}
