package com.shuyu.chat.application.rest.controller;

import com.shuyu.chat.application.domain.entity.ChatUser;
import com.shuyu.chat.application.rest.dto.ChatUserDto;
import com.shuyu.chat.application.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ChatUser userLogin(@RequestBody ChatUserDto userDto){
        return userService.registerUser(userDto.getUsername());
    }

    @GetMapping("/list")
    public List<ChatUser> getListUser(){
        return userService.getUsers();
    }

}
