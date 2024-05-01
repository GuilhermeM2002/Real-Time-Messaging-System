package br.com.challenges.message.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MessageDto {
    private  Long id;
    private String whoSend;
    private String whoReceive;
    private String content;
    private OffsetDateTime date;
}
