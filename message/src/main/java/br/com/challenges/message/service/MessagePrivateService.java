package br.com.challenges.message.service;

import br.com.challenges.message.adapters.repository.MessagePrivateRepository;
import br.com.challenges.message.avro.PrivateMessageAvro;
import br.com.challenges.message.core.domain.MessagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;

@Service
public class MessagePrivateService {
    @Autowired
    private MessagePrivateRepository messagePrivateRepository;

    @KafkaListener(topics = "message-sent", groupId = "group", containerFactory = "kafkaListenerContainerFactory")
    public void saveMessageFromKafkaTopic(PrivateMessageAvro messageAvro){
        MessagePrivate message = new MessagePrivate();

        message.setId(Long.valueOf(messageAvro.getId().toString()));
        message.setContent(messageAvro.getContent().toString());
        message.setDate(Date.from(messageAvro.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        message.setWhoSend(messageAvro.getWhoSend().toString());
        message.setWhoReceive(messageAvro.getWhoReceive().toString());

        messagePrivateRepository.save(message);
    }
}
