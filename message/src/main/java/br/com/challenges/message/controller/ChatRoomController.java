package br.com.challenges.message.controller;

import br.com.challenges.message.application.dto.ChatRoomDto;
import br.com.challenges.message.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chat-room")
public class ChatRoomController {
    @Autowired
    private ChatRoomService chatRoomService;

    @PostMapping
    public ResponseEntity<ChatRoomDto> createRoom(@RequestBody ChatRoomDto chatRoom) {
        var createdRoom = chatRoomService.createRoom(chatRoom);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRoom);
    }
}
