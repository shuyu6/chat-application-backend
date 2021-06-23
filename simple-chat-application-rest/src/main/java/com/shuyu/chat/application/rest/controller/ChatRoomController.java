package com.shuyu.chat.application.rest.controller;

import com.shuyu.chat.application.rest.dto.ChatRoomIdDto;
import com.shuyu.chat.application.rest.dto.ChatRoomIdInquiryDto;
import com.shuyu.chat.application.rest.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * =============================================================================
 * -----------------------------------------------------------------------------
 *
 * @author Shu Yu 22/6/2021
 * <p>
 * -----------------------------------------------------------------------------
 * =============================================================================
 **/
@RestController
@RequestMapping("/chat")
public class ChatRoomController {

    @Autowired
    private ChatRoomService chatRoomService;

    @PostMapping("/chat-room-id")
    public ChatRoomIdDto retrieveChatRoomId(@RequestBody ChatRoomIdInquiryDto chatRoomIdInquiryDto){
        BigDecimal chatRoomId = chatRoomService.findChatRoomBySenderIdAndReceiverId(chatRoomIdInquiryDto.getSenderId(), chatRoomIdInquiryDto.getReceiverId());
        return new ChatRoomIdDto(chatRoomId);
    }
}
