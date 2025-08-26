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
        // message.getName() contains the name sent by the client from frontend
        return new Hello("Hello! " + message.getName() + "has joined!");
    }

    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public Chat chat(ChatMessage chat) {
        System.out.println("/chat endpoint hit with message: " + chat.getContent());
        return new Chat(chat.getContent());
    }

}
