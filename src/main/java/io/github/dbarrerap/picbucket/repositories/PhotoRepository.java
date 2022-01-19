package io.github.dbarrerap.picbucket.repositories;

import io.github.dbarrerap.picbucket.entities.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {
}
