package com.shuyu.chat.application.domain.repository;

import com.shuyu.chat.application.domain.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
@Repository
public interface JpaChatMessageRepository extends JpaRepository<ChatMessage, BigDecimal> {
}
