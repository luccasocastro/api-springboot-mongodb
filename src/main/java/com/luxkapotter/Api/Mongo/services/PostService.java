package com.luxkapotter.Api.Mongo.services;

import com.luxkapotter.Api.Mongo.entities.Post;
import com.luxkapotter.Api.Mongo.entities.User;
import com.luxkapotter.Api.Mongo.repositories.PostRepository;
import com.luxkapotter.Api.Mongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        if(post.isEmpty()){
            throw new ObjectNotFoundException("Post doesn't exists!");
        }
        return post.get();
    }

    public List<Post> findByTitle(String text){
        return repository.findByTitleContainingIgnoreCase(text);
    }
}
