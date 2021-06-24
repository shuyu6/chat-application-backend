package com.shuyu.chat.application.websocket.controller;

import com.shuyu.chat.application.websocket.dto.ChatMessageDto;
import com.shuyu.chat.application.websocket.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatService chatService;

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessageDto chatMessageDto) {
        var notification = chatService.sendMessage(chatMessageDto);

        // return url = /user/{chatRoomId}/queue/message
        messagingTemplate.convertAndSendToUser(chatMessageDto.getChatRoomId().toString(),"/queue/messages", notification);

        List<BigDecimal> retrieveIds = chatService.retrieveReceiverIdsByChatRoomIdAndSenderId(notification.getChatRoomId(), notification.getSenderId());

        for(BigDecimal retrieverIds: retrieveIds){
            messagingTemplate.convertAndSendToUser(retrieverIds.toString(),"/queue/notification", notification);
        }


    }
}