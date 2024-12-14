package br.com.challenges.message.controller;

import br.com.challenges.message.application.dto.ChatInput;
import br.com.challenges.message.application.dto.ChatOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ChatController {
    @Autowired
    private KafkaTemplate<String, ChatInput> kafkaTemplate;

    @MessageMapping("/new-message")
    @SendTo("/topic/livechat")
    public ChatOutput newMessage(@Payload ChatInput dto){
        kafkaTemplate.send("message-group-sent", dto);

        return  new ChatOutput(HtmlUtils.htmlEscape(dto.user() + ": " + dto.message()));
    }
}
