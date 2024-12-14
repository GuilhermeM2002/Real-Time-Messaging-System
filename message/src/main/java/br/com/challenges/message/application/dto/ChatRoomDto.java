package br.com.challenges.message.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChatRoomDto {
    private ObjectId id;
    private String name;
    private List<String> messages;
    private List<String> users;
}
