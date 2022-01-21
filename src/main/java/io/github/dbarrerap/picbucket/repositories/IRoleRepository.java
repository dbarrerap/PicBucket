package io.github.dbarrerap.picbucket.repositories;

import io.github.dbarrerap.picbucket.entities.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRoleRepository extends MongoRepository<Role, String> {
    Role findByName(String name);
}
