package br.com.challenges.message.core.useCases;

import br.com.challenges.message.application.dto.MessageDto;

public interface SendMassageUseCase {
    public MessageDto sendMessage(MessageDto dto);
}
