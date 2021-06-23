package com.shuyu.chat.application.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
@Entity
@Table(name="chat_room")
@Getter
public class ChatRoom {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "chat_room_id")
    private BigDecimal id;
}
