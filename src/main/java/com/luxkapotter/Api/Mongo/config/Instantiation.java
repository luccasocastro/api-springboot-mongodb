package com.luxkapotter.Api.Mongo.config;

import com.luxkapotter.Api.Mongo.entities.Post;
import com.luxkapotter.Api.Mongo.entities.User;
import com.luxkapotter.Api.Mongo.repositories.PostRepository;
import com.luxkapotter.Api.Mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User nicolly = new User(null, "Nicolly", "nicpic@mail.com");
        User luccas = new User(null, "Luccas", "luscca@mail.com");
        User mary = new User(null, "Mary Joseph", "maryjoseph@mail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", mary);
        Post post2 = new Post(null, sdf.parse("15/03/2023"), "Estudando MongoDB", "Criando aqui uma API com MongoDB", luccas);

        userRepository.saveAll(Arrays.asList(nicolly, luccas, mary));
        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}
