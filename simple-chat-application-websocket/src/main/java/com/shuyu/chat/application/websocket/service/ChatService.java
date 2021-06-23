package com.shuyu.chat.application.websocket.service;

import com.shuyu.chat.application.domain.entity.ChatMessage;
import com.shuyu.chat.application.domain.entity.ChatUser;
import com.shuyu.chat.application.domain.repository.JpaChatMessageRepository;
import com.shuyu.chat.application.domain.repository.JpaUserRepository;
import com.shuyu.chat.application.websocket.dto.ChatMessageDto;
import com.shuyu.chat.application.websocket.dto.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * =============================================================================
 * -----------------------------------------------------------------------------
 *
 * @author Shu Yu 23/6/2021
 * <p>
 * -----------------------------------------------------------------------------
 * =============================================================================
 **/
@Service
public class ChatService {
    @Autowired
    private JpaChatMessageRepository chatMessageRepository;

    @Autowired
    private JpaUserRepository userRepository;

    public Notification sendMessage(ChatMessageDto chatMessageDto){
        var chatMessage = new ChatMessage(chatMessageDto.getChatRoomId(), chatMessageDto.getSenderId(), chatMessageDto.getContent());
        chatMessage = chatMessageRepository.save(chatMessage);

        Optional<ChatUser> chatUser = userRepository.findById(chatMessage.getSenderId());

        return Notification.builder().chatRoomId(chatMessage.getChatRoomId())
                .content(chatMessage.getContent())
                .senderId(chatMessage.getSenderId())
                .senderUsername(chatUser.isPresent()?chatUser.get().getUsername():"Anonymous")
                .timestamp(chatMessage.getCreatedTimestamp().toString())
                .receiverId(chatMessage.getSenderId())
                .build();
    }
}
