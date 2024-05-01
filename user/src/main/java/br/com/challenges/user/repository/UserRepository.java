package br.com.challenges.user.repository;

import br.com.challenges.user.core.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
    User FindByUserName(String userName);
}
