package com.shuyu.chat.application.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * =============================================================================
 * -----------------------------------------------------------------------------
 *
 * @author Shu Yu 22/6/2021
 * <p>
 * -----------------------------------------------------------------------------
 * =============================================================================
 **/
@Entity
@Table(name="chat_message")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChatMessage {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "message_id")
    private BigDecimal id;

    @Column(name = "chat_room_id")
    private BigDecimal chatRoomId;

    @Column(name = "sender_id")
    private BigDecimal senderId;

    @Column(name = "content")
    private String content;

    @Column(name = "created_timestamp")
    private Timestamp createdTimestamp;

    public ChatMessage(BigDecimal chatRoomId, BigDecimal senderId, String content){

        this.chatRoomId = chatRoomId;
        this.senderId = senderId;
        this.content = content;
        this.createdTimestamp = Timestamp.from(Instant.now());
    }

}
