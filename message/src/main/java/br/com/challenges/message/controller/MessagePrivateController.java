package br.com.challenges.message.controller;

import br.com.challenges.message.adapters.repository.MessagePrivateRepository;
import br.com.challenges.message.application.dto.MessageDto;
import br.com.challenges.message.avro.PrivateMessageAvro;
import br.com.challenges.message.core.domain.MessagePrivate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.ZoneId;

@Controller
public class MessagePrivateController {
    @Autowired
    private MessagePrivateRepository messagePrivateRepository;
    @Autowired
    private KafkaTemplate<String, PrivateMessageAvro> kafkaTemplate;
    @Autowired
    private ModelMapper mapper; 

    @MessageMapping("private-message")
    @SendTo("/topic/private-chat")
    public MessageDto sendPrivateMessage(@Payload MessageDto dto) {
        var message = mapper.map(dto, MessagePrivate.class);

        var messageAvro = new PrivateMessageAvro();
        messageAvro.setContent(message.getContent());
        messageAvro.setDate(message.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        messageAvro.setId(message.getId().toString());
        messageAvro.setWhoSend(message.getWhoSend());
        messageAvro.setWhoReceive(message.getWhoReceive());

        kafkaTemplate.send("message-sent", messageAvro.getWhoSend().toString(), messageAvro);
        messagePrivateRepository.save(message);
        return dto;
    }
}
