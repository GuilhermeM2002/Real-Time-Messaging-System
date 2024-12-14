package br.com.challenges.message.core.domain;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "chat-room")
public class ChatRoom {
    @Id
    private ObjectId id;
    private String name;
    private List<String> messages;
    private List<String> users;
}
