package br.com.challenges.message.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "message")
public class Message {
    @Id
    private  Long id;
    private String whoSend;
    private String whoReceive;
    private String content;
    private OffsetDateTime date;
}
