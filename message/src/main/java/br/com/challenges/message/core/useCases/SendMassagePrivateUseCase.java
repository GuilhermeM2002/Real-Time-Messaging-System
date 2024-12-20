package br.com.challenges.message.core.useCases;

import br.com.challenges.message.application.dto.MessageDto;

public interface SendMassagePrivateUseCase {
    public MessageDto sendMessage(MessageDto dto);
}
