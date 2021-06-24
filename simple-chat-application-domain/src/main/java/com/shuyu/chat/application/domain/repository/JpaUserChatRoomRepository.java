package com.shuyu.chat.application.domain.repository;

import com.shuyu.chat.application.domain.entity.UserChatRoom;
import com.shuyu.chat.application.domain.entity.UserChatRoomId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
public interface JpaUserChatRoomRepository extends JpaRepository<UserChatRoom, UserChatRoomId> {
    @Query(
            "SELECT s.id.chatRoomId " +
            "FROM UserChatRoom s, UserChatRoom r "+
            "WHERE s.id.chatRoomId = r.id.chatRoomId " +
                "and s.id.userId != r.id.userId " +
                "and s.id.userId = :senderId " +
                "and r.id.userId = :receiverId "
    )
    Optional<BigDecimal> findChatRoomIdBySenderIdAndReceiverId(@Param("senderId") BigDecimal senderId, @Param("receiverId") BigDecimal receiverId);

    List<UserChatRoom> findByIdChatRoomIdAndIdUserIdNot(BigDecimal chatRoomId, BigDecimal senderId);

}
