package com.luxkapotter.Api.Mongo.config;

import com.luxkapotter.Api.Mongo.entities.User;
import com.luxkapotter.Api.Mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User nicolly = new User(null, "Nicolly", "nicpic@mail.com");
        User luccas = new User(null, "Luccas", "luscca@mail.com");
        User mary = new User(null, "Mary Joseph", "maryjoseph@mail.com");

        userRepository.saveAll(Arrays.asList(nicolly, luccas, mary));

    }
}
