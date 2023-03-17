package com.luxkapotter.Api.Mongo.controllers;

import com.luxkapotter.Api.Mongo.entities.Post;
import com.luxkapotter.Api.Mongo.entities.User;
import com.luxkapotter.Api.Mongo.entities.UserResponseDTO;
import com.luxkapotter.Api.Mongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable(value = "id") String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
