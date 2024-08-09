package br.com.challenges.user.application.useCasesImpl;

import br.com.challenges.user.application.dto.ReceivedMessageDto;
import br.com.challenges.user.core.useCases.MessagesQuantifierUseCase;
import br.com.challenges.user.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.avro.generic.GenericRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessagesQuantifierUseCaseImpl implements MessagesQuantifierUseCase   {
    @Autowired
    private UserRepository repository;
    @Override
    @KafkaListener(topics = "message-sent", groupId = "group")
    public void messagesQuantifier(GenericRecord data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        String jsonString = data.toString();

        ReceivedMessageDto message = objectMapper.readValue(jsonString, ReceivedMessageDto.class);

        var user = repository.findByUserName(message.getWhoReceive());

        var newQuantity = user.getQuantityOfMessages() + 1;
        user.setQuantityOfMessages(newQuantity);
        repository.save(user);
    }
}
