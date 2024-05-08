package br.com.challenges.message.application.useCaseImpl;

import br.com.challenges.message.application.dto.MessageDto;
import br.com.challenges.message.core.useCases.ReceiveMessageUseCase;
import br.com.challenges.message.adapters.http.UserClient;
import br.com.challenges.message.adapters.repository.MessageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReceiveMessageUseCaseImpl implements ReceiveMessageUseCase {
    @Autowired
    private UserClient userClient;
    @Autowired
    private MessageRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public List<MessageDto> messageReceived(String userName) {
        var user = userClient.getUser(userName);
        if (user == null){
            throw new RuntimeException("Invalid user name.");
        }
        var messages = repository.findByWhoReceive(userName);
        return messages.stream().map(message -> mapper.map(message, MessageDto.class)).toList();
    }
}
