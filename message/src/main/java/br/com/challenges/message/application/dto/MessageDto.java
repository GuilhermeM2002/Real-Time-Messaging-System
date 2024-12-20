package br.com.challenges.message.application.dto;

import br.com.challenges.message.core.domain.MessageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MessageDto {
    private ObjectId id;
    private String whoSend;
    private String whoReceive;
    private String content;
    private Date date;
    private MessageType type;
}
