package com.shuyu.chat.application.websocket.dto;

import lombok.Builder;
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
@Builder
public class Notification {
    private BigDecimal chatRoomId;
    private BigDecimal receiverId;
    private BigDecimal senderId;
    private String senderUsername;
    private String content;
    private String timestamp;
}
