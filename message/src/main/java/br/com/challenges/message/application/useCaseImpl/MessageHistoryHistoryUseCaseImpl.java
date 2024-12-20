package br.com.challenges.message.application.useCaseImpl;

import br.com.challenges.message.application.dto.MessageDto;
import br.com.challenges.message.core.useCases.MessageHistoryUseCase;
import br.com.challenges.message.adapters.http.UserClient;
import br.com.challenges.message.adapters.repository.MessagePrivateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageHistoryHistoryUseCaseImpl implements MessageHistoryUseCase {
    @Autowired
    private UserClient userClient;
    @Autowired
    private MessagePrivateRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public List<MessageDto> getMessageHistory(String senderUserName, String recipientUserName) {
        var user1 = userClient.getUser(senderUserName);
        var user2 = userClient.getUser(recipientUserName);
        if (user1 == null || user2 == null){
            throw new RuntimeException("Invalid user name.");
        }
        var messages = repository.findMessagesBetweenUsernames(senderUserName, recipientUserName);
        return messages.stream().map(message -> mapper.map(message, MessageDto.class)).toList();
    }
}
