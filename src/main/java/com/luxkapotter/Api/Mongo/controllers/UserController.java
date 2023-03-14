package com.luxkapotter.Api.Mongo.controllers;

import com.luxkapotter.Api.Mongo.entities.User;
import com.luxkapotter.Api.Mongo.entities.UserResponseDTO;
import com.luxkapotter.Api.Mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Object> findById(@PathVariable(value = "id") String id){
        Optional<UserResponseDTO> obj = service.findById(id).map(UserResponseDTO::new);
        return ResponseEntity.ok().body(obj);
    }
}
