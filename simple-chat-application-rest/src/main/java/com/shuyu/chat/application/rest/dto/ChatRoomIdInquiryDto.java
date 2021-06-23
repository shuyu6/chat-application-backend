package com.shuyu.chat.application.rest.dto;

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
public class ChatRoomIdInquiryDto {
    private BigDecimal senderId;
    private BigDecimal receiverId;
}
