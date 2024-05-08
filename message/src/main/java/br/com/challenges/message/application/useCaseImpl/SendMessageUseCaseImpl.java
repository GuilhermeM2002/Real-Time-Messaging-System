package br.com.challenges.message.application.useCaseImpl;

import br.com.challenges.message.application.dto.MessageDto;
import br.com.challenges.message.core.domain.Message;
import br.com.challenges.message.core.useCases.SendMassageUseCase;
import br.com.challenges.message.adapters.repository.MessageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendMessageUseCaseImpl implements SendMassageUseCase {
    @Autowired
    private MessageRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private KafkaTemplate<String, MessageDto> kafkaTemplate;
    @Override
    public MessageDto sendMessage(MessageDto dto) {
        var message = mapper.map(dto, Message.class);
        repository.save(message);
        var messageDto = mapper.map(message, MessageDto.class);
        kafkaTemplate.send("message-sent", messageDto);

        return messageDto;
    }
}
