package org.apache.maven.archetypes.maven_archetype_quickstart.repository;

import org.apache.maven.archetypes.maven_archetype_quickstart.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByName(String name);
}
