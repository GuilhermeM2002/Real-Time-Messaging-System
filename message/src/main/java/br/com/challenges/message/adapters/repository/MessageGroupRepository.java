package br.com.challenges.message.adapters.repository;

import br.com.challenges.message.core.domain.MessageGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageGroupRepository extends MongoRepository<MessageGroup, Long> {
}
