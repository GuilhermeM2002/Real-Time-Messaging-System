package br.com.challenges.message.core.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "message_group")
public class MessageGroup {
    @Id
    private Long id;
    private String user;
    private String message;
    private Long roomId;
}
