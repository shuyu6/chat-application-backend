package com.shuyu.chat.application.rest.dto;

import com.shuyu.chat.application.domain.model.ChatMessageModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * =============================================================================
 * COPYRIGHT (C) SOLDERFIELD
 * <p>
 * ALL RIGHTS RESERVED. SOLDERFIELD'S SOURCE CODE IS AN UNPUBLISHED WORK AND
 * THE USE OF COPYRIGHT NOTICE DOES NOT IMPLY  OTHERWISE.  THIS  SOURCE  CODE
 * CONTAINS CONFIDENTIAL, TRADE SECRET MATERIAL OF SOLDERFIELD. ANY  ATTEMPT
 * OR PARTICIPATION IN DECIPHERING, DECODING, REVERSE ENGINEERING OR IN  ANY
 * WAY ALTERING THE SOURCE CODE IS STRICTLY  PROHIBITED,  UNLESS  THE  PRIOR
 * WRITTEN CONSENT OF SOLDERFIELD IS OBTAINED.
 * -----------------------------------------------------------------------------
 *
 * @author Shu Yu 23/6/2021
 * <p>
 * -----------------------------------------------------------------------------
 * =============================================================================
 **/
@Setter
@Getter
public class ChatMessageDto implements Serializable {
    private boolean hasNext;
    private long totalRecord;
    private List<ChatMessageModel> messageList;
}
