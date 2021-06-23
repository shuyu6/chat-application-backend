package com.shuyu.chat.application.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * =============================================================================
 * -----------------------------------------------------------------------------
 *
 * @author Shu Yu 23/6/2021
 * <p>
 * -----------------------------------------------------------------------------
 * =============================================================================
 **/

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageModel implements Serializable {
    @Column(name="message_id")
    private BigDecimal id;

    @Column(name="sender_id")
    private BigDecimal senderId;

    @Column(name="username")
    private String username;

    @Column(name="content")
    private String content;

    @Column(name="created_timestamp")
    private String timestamp;
}
