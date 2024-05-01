package br.com.challenges.message.application.useCaseImpl;

import br.com.challenges.message.application.dto.MessageDto;
import br.com.challenges.message.core.useCases.ReceiveMessageUseCase;
import br.com.challenges.message.http.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;

public class ReceiveMessageUseCaseImpl implements ReceiveMessageUseCase {
    @Autowired
    private UserClient userClient;

    @Override
    @KafkaListener(topics = "message-sent", groupId = "group")
    public ResponseEntity<String> messageReceived(MessageDto dto) {
        var user = userClient.getUser(dto.getHow());
        if (user == null){
            return new ResponseEntity<>("User invalid", HttpStatus.BAD_REQUEST);
        }
        String responseMessage = "New message received " + dto.getHow() + " " + dto.getContent();
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
