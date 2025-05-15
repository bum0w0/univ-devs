package com.hallym.websocket.controller;

import com.hallym.websocket.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/room/{roomId}")  // /app/room/123
    @SendTo("/topic/room/{roomId}")    // /topic/room/123
    public ChatMessage sendToRoom(@DestinationVariable String roomId, ChatMessage message) {
        System.out.println("Room " + roomId + " >> " + message.getSender() + ": " + message.getContent());
        return message;
    }
}