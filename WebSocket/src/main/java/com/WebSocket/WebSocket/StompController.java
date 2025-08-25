package com.WebSocket.WebSocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class StompController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Hello hello(HelloMessage message) {
        System.out.println("/hello endpoint hit with message: " + message.getName());
        return new Hello("Hello, " + message.getName() + "!");
    }

}
