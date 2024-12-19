package br.com.challenges.message.core.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "chat-room")
public class ChatRoom {
    @Id
    private Long id;
    private String name;
    private List<String> messages = new ArrayList<>();
    private List<String> users = new ArrayList<>();
}
