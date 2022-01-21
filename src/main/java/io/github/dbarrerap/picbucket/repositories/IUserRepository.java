package io.github.dbarrerap.picbucket.repositories;

import io.github.dbarrerap.picbucket.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
