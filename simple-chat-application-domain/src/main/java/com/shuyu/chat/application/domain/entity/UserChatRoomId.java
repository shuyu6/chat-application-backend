package com.shuyu.chat.application.domain.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
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
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserChatRoomId implements Serializable {

    @Column(name = "chat_room_id")
    private BigDecimal chatRoomId;

    @Column(name = "user_id")
    private BigDecimal userId;
}
