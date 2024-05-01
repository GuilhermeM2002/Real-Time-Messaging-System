package br.com.challenges.message.controller;

import br.com.challenges.message.application.dto.MessageDto;
import br.com.challenges.message.application.useCaseImpl.ReceiveMessageUseCaseImpl;
import br.com.challenges.message.application.useCaseImpl.SendMessageUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    private SendMessageUseCaseImpl sendMessageUseCase;
    @Autowired
    private ReceiveMessageUseCaseImpl receiveMessageUseCase;
    @PostMapping
    public ResponseEntity<MessageDto> sendMessage(@RequestBody MessageDto dto, UriComponentsBuilder uriComponentsBuilder){
        var message = sendMessageUseCase.sendMessage(dto);
        var uri = uriComponentsBuilder.path("message/{id}").buildAndExpand(message.getId()).toUri();

        return ResponseEntity.created(uri).body(message);
    }
    @GetMapping
    public ResponseEntity<List<MessageDto>> receiveMessage(@PathVariable String userName){
        var messages = receiveMessageUseCase.messageReceived(userName);

        return ResponseEntity.ok(messages);
    }
}
