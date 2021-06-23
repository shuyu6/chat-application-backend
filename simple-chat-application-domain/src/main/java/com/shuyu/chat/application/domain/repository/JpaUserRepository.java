package com.shuyu.chat.application.domain.repository;

import com.shuyu.chat.application.domain.entity.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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
public interface JpaUserRepository extends JpaRepository<ChatUser, BigDecimal> {
    Optional<ChatUser> findByUsername(String username);
}
