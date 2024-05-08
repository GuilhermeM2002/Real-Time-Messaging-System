package br.com.challenges.user.application.useCasesImpl;

import br.com.challenges.user.application.dto.MessageDto;
import br.com.challenges.user.core.useCases.MessagesQuantifierUseCase;
import br.com.challenges.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Objects;

public class MessagesQuantifierUseCaseImpl implements MessagesQuantifierUseCase   {
    @Autowired
    private UserRepository repository;
    @Override
    @KafkaListener(topics = "message-sent", groupId = "group")
    public void messagesQuantifier(MessageDto dto, String myUserName) {
        var user = repository.findByUserName(dto.getWhoReceive());
        if(Objects.equals(user.getUserName(), myUserName)){
            var newQuantity = user.getQuantityOfMessages() + 1;
            user.setQuantityOfMessages(newQuantity);

            repository.save(user);
        }
    }
}
