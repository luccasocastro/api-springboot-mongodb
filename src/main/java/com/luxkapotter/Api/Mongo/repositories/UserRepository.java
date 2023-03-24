package com.luxkapotter.Api.Mongo.repositories;

import com.luxkapotter.Api.Mongo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
