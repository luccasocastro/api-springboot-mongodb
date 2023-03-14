package com.luxkapotter.Api.Mongo.controllers;

import com.luxkapotter.Api.Mongo.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
          User maria = new User("1", "Maria Brown", "maria@mail.com");
          User alex = new User("2", "Alex Green", "alex@gmail.com");
          List<User> list = new ArrayList<>();
          list.addAll(Arrays.asList(maria, alex));
          return ResponseEntity.ok().body(list);
    }
}
