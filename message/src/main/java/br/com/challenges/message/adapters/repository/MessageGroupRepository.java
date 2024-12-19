package br.com.challenges.message.adapters.repository;

import br.com.challenges.message.application.dto.ChatInput;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageGroupRepository extends MongoRepository<ChatInput, Long> {
}
