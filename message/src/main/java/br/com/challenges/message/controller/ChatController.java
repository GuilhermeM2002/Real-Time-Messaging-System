package br.com.challenges.message.controller;

import br.com.challenges.message.application.dto.ChatInput;
import br.com.challenges.message.application.dto.ChatOutput;
import br.com.challenges.message.application.dto.MessageDto;
import br.com.challenges.message.application.dto.UserDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ChatController {

    @MessageMapping("/new-message")
    @SendTo("/topics/livechat")
    public ChatOutput newMessage(@Payload ChatInput dto){
        return  new ChatOutput(HtmlUtils.htmlEscape(dto.user() + ": " + dto.message()));
    }
}
