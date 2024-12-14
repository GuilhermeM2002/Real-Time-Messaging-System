package br.com.challenges.message.adapters.repository;

import br.com.challenges.message.core.domain.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, Long> {
}
