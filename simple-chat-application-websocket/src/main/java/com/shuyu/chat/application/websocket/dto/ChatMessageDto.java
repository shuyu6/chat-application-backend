package com.shuyu.chat.application.websocket.dto;

import lombok.Getter;

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
@Getter
public class ChatMessageDto {
    private BigDecimal chatRoomId;
    private BigDecimal senderId;
    private String content;
}
