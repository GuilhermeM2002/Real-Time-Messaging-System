package br.com.challenges.message.core.useCases;

import br.com.challenges.message.application.dto.MessageDto;

import java.util.List;

public interface MessageHistoryUseCase {
    public List<MessageDto> getMessageHistory(String senderUserName, String recipientUserName);
}
