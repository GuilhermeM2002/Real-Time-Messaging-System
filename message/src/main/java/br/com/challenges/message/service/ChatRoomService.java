package br.com.challenges.message.service;

import br.com.challenges.message.adapters.http.UserClient;
import br.com.challenges.message.adapters.repository.ChatRoomRepository;
import br.com.challenges.message.application.dto.ChatRoomDto;
import br.com.challenges.message.core.domain.ChatRoom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomService {
    @Autowired
    private ChatRoomRepository chatRoomRepository;
    @Autowired
    private UserClient userClient;
    @Autowired
    private ModelMapper mapper;

    public ChatRoomDto createRoom(ChatRoomDto dto){
        var room = mapper.map(dto, ChatRoom.class);
        chatRoomRepository.save(room);
        return mapper.map(room, ChatRoomDto.class);
    }

    public void addUserToRoom(Long id, String userName){
        var chatRoom = chatRoomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        var user = userClient.getUser(userName);
        if (user == null){
            throw new RuntimeException("User not found");
        }
        chatRoom.getUsers().add(userName);
        chatRoomRepository.save(chatRoom);
    }
}
