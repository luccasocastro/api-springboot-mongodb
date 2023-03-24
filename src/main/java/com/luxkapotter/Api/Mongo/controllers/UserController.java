package com.luxkapotter.Api.Mongo.controllers;

import com.luxkapotter.Api.Mongo.entities.Post;
import com.luxkapotter.Api.Mongo.entities.User;
import com.luxkapotter.Api.Mongo.entities.UserRequestDTO;
import com.luxkapotter.Api.Mongo.entities.UserResponseDTO;
import com.luxkapotter.Api.Mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll(){
          List<UserResponseDTO> list = service.findAll().stream().map(UserResponseDTO::new).toList();
          return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable(value = "id") String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserResponseDTO(obj));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> insert(@RequestBody UserRequestDTO objDto){
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        return ResponseEntity.ok().body(new UserResponseDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> update(@RequestBody UserRequestDTO objDto, @PathVariable(value = "id") String id){
        User obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.ok().body(new UserResponseDTO(obj));
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable(value = "id") String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj.getPosts());
    }
}
