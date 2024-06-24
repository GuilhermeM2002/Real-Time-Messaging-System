package br.com.challenges.user.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private ObjectId id;
    private String userName;
    private String email;
    private int quantityOfMessages;
}
