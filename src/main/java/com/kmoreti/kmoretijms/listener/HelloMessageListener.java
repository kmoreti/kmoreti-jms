package com.kmoreti.kmoretijms.listener;

import com.kmoreti.kmoretijms.config.JmsConfig;
import com.kmoreti.kmoretijms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.UUID;

//@Component
@RequiredArgsConstructor
public class HelloMessageListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage, @Headers MessageHeaders headers, Message message) {

//        System.out.println("I Got a Message");

//        System.out.println(helloWorldMessage);
    }

    @JmsListener(destination = JmsConfig.MY_SEND_RCV_QUEUE)
    public void listenForHello(@Payload HelloWorldMessage helloWorldMessage, @Headers MessageHeaders headers, Message message) throws JMSException {
        System.out.println("Received message: " + helloWorldMessage.getMessage());
        HelloWorldMessage payloadMsg = HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("World")
                .build();

        jmsTemplate.convertAndSend(message.getJMSReplyTo(), payloadMsg);
    }
}
