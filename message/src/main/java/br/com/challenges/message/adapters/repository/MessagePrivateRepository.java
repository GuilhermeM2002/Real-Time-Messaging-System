package br.com.challenges.message.adapters.repository;

import br.com.challenges.message.core.domain.MessagePrivate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessagePrivateRepository extends MongoRepository<MessagePrivate, Long> {
    List<MessagePrivate> findByWhoReceive(String userName);

    @Query("{ $or: [ " +
            "{ $and: [ { 'whoSend': :#{#username1} }, { 'whoReceive': :#{#username2} } ] }, " +
            "{ $and: [ { 'whoSend': :#{#username2} }, { 'whoReceive': :#{#username1} } ] } ] }" +
            " ORDER BY date ASC")
    List<MessagePrivate> findMessagesBetweenUsernames(@Param("username1") String username1, @Param("username2") String username2);

}
