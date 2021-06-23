package com.shuyu.chat.application.rest.service;

import com.shuyu.chat.application.domain.entity.ChatUser;
import com.shuyu.chat.application.domain.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class UserService {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    public ChatUser registerUser(String username){
        Optional<ChatUser> chatUser = jpaUserRepository.findByUsername(username);
        if (chatUser.isPresent()){
            return chatUser.get();
        }else {
            var newChatUser = new ChatUser();
            newChatUser.setUsername(username);

            return jpaUserRepository.save(newChatUser);
        }
    }

    public List<ChatUser> getUsers(){
        return jpaUserRepository.findAll();
    }
}
