package br.com.challenges.message.repository;

import br.com.challenges.message.core.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, Long> {
}
