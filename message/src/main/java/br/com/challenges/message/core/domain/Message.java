package br.com.challenges.message.core.domain;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "message")
public class Message {
    @Id
    private ObjectId id;
    private String whoSend;
    private String whoReceive;
    private String content;
    private Date date;
    private MessageType type;
}