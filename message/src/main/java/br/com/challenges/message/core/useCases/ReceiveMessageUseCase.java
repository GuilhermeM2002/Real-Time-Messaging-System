package br.com.challenges.message.core.useCases;

import br.com.challenges.message.application.dto.MessageDto;
import org.springframework.http.ResponseEntity;

public interface ReceiveMessageUseCase {
    public ResponseEntity<String> messageReceived(MessageDto dto);
}
