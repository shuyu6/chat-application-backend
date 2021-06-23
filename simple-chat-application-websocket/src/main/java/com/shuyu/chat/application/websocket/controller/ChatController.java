package com.shuyu.chat.application.websocket.controller;

import com.shuyu.chat.application.websocket.dto.ChatMessageDto;
import com.shuyu.chat.application.websocket.dto.Notification;
import com.shuyu.chat.application.websocket.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatService chatService;

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessageDto chatMessageDto) {
        Notification notification = chatService.sendMessage(chatMessageDto);

        // return url = /user/{chatRoomId}/queue/message
        messagingTemplate.convertAndSendToUser(chatMessageDto.getChatRoomId().toString(),"/queue/messages", notification);
    }
}