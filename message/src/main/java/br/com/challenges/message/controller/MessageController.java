package br.com.challenges.message.controller;

import br.com.challenges.message.application.dto.MessageDto;
import br.com.challenges.message.application.useCaseImpl.SendMessageUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    private SendMessageUseCaseImpl sendMessageUseCase;
    public ResponseEntity<MessageDto> sendMessage(@RequestBody MessageDto dto, UriComponentsBuilder uriComponentsBuilder){
        var message = sendMessageUseCase.sendMessage(dto);
        var uri = uriComponentsBuilder.path("message/{id}").buildAndExpand(message.getId()).toUri();

        return ResponseEntity.created(uri).body(message);
    }
}
