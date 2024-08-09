package br.com.challenges.user.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReceivedMessageDto {
    private  String id;
    private String whoSend;
    private String whoReceive;
    private String content;
    private OffsetDateTime date;
}
