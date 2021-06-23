package com.shuyu.chat.application.domain.repository;

import com.shuyu.chat.application.domain.entity.ChatMessage;
import com.shuyu.chat.application.domain.model.ChatMessageModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

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
    @Query(
            "SELECT new com.shuyu.chat.application.domain.model.ChatMessageModel(m.id, m.senderId, u.username, m.content, cast(m.createdTimestamp as string)) " +
            "FROM ChatMessage m JOIN ChatUser u ON m.senderId = u.userId " +
            "WHERE m.chatRoomId = :chatRoomId "+
            "ORDER BY m.createdTimestamp DESC "
    )
    List<ChatMessageModel> findChatMessageByChatRoomId(@Param("chatRoomId") BigDecimal chatRoomId, Pageable pageable);

    long countByChatRoomId(BigDecimal chatRoomId);
}
