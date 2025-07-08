package br.com.challenges.message.service;

import br.com.challenges.message.adapters.http.UserClient;
import br.com.challenges.message.adapters.repository.ChatRoomRepository;
import br.com.challenges.message.adapters.repository.MessageGroupRepository;
import br.com.challenges.message.application.dto.ChatInput;
import br.com.challenges.message.application.dto.ChatRoomDto;
import br.com.challenges.message.avro.GroupMessageAvro;
import br.com.challenges.message.core.domain.ChatRoom;
import br.com.challenges.message.core.domain.MessageGroup;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomService {
    @Autowired
    private ChatRoomRepository chatRoomRepository;
    @Autowired
    private MessageGroupRepository messageGroupRepository;
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

    @KafkaListener(topics = "message-group-sent", groupId = "group-group", containerFactory = "kafkaListenerContainerFactory")
    public void saveNewMessage(GroupMessageAvro groupMessageAvro){
        MessageGroup messageGroup = new MessageGroup();
        messageGroup.setMessage(groupMessageAvro.getMessage().toString());
        messageGroup.setUser(groupMessageAvro.getUser().toString());
        messageGroup.setRoomId(groupMessageAvro.getRoomId());

        messageGroupRepository.save(messageGroup);
    }
}
