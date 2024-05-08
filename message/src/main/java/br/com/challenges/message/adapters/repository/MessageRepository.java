package br.com.challenges.message.adapters.repository;

import br.com.challenges.message.core.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, Long> {
    List<Message> findByWhoReceive(String userName);
}
