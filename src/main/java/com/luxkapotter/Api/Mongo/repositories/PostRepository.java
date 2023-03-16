package com.luxkapotter.Api.Mongo.repositories;

import com.luxkapotter.Api.Mongo.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
