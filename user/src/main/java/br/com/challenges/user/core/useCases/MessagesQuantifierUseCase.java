package br.com.challenges.user.core.useCases;

import br.com.challenges.user.application.dto.MessageDto;

public interface MessagesQuantifierUseCase {
    void messagesQuantifier(MessageDto dto, String myUserName);
}
