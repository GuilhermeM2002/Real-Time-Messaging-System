package br.com.challenges.message.controller;

import br.com.challenges.message.application.dto.MessageDto;
import br.com.challenges.message.application.dto.UserDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/new-message")
    @SendTo("/topic/public")
    public MessageDto newMessage(@Payload MessageDto dto){
        return  dto;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public UserDto addUser(
            @Payload UserDto user,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", user.getUserName());
        return user;
    }
}
