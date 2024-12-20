package br.com.challenges.message.controller;

import br.com.challenges.message.application.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

@MessageMapping("private-message")
@SendTo("/topic/private-chat")
public class MessagePrivateController {
    public MessageDto sendPrivateMessage(@Payload MessageDto dto) {
        return dto;
    }
}
