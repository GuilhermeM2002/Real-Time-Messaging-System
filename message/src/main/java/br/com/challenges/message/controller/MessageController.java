package br.com.challenges.message.controller;

import br.com.challenges.message.application.dto.MessageDto;
import br.com.challenges.message.application.useCaseImpl.MessageHistoryHistoryUseCaseImpl;
import br.com.challenges.message.application.useCaseImpl.SendMessagePrivateUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private SendMessagePrivateUseCaseImpl sendMessageUseCase;
    @Autowired
    private MessageHistoryHistoryUseCaseImpl receiveMessageUseCase;

    @PostMapping
    @Transactional
    public ResponseEntity<MessageDto> sendMessage(@RequestBody MessageDto dto, UriComponentsBuilder uriComponentsBuilder){
        var message = sendMessageUseCase.sendMessage(dto);
        var uri = uriComponentsBuilder.path("/message/{id}").buildAndExpand(message.getId()).toUri();

        return ResponseEntity.created(uri).body(message);
    }
    @GetMapping("/history")
    public ResponseEntity<List<MessageDto>> receiveMessage(@RequestParam String senderUserName, @RequestParam String recipientUserName){
        var messages = receiveMessageUseCase.getMessageHistory(senderUserName, recipientUserName);

        return ResponseEntity.ok(messages);
    }
}
