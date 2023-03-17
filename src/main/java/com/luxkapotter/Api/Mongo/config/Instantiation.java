package com.luxkapotter.Api.Mongo.config;

import com.luxkapotter.Api.Mongo.entities.AuthorResponseDTO;
import com.luxkapotter.Api.Mongo.entities.CommentResponseDTO;
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

        userRepository.saveAll(Arrays.asList(nicolly, luccas, mary));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorResponseDTO(mary));
        Post post2 = new Post(null, sdf.parse("15/03/2023"), "Estudando MongoDB", "Criando aqui uma API com MongoDB", new AuthorResponseDTO(luccas));
        Post post3 = new Post(null, sdf.parse("24/05/2022"), "Parabéns!!", "Comemorando meu aniver hoje!!", new AuthorResponseDTO(luccas));

        CommentResponseDTO c1 = new CommentResponseDTO("Parabéns, Luccas!!", sdf.parse("24/05/2022"), new AuthorResponseDTO(nicolly));
        CommentResponseDTO c2 = new CommentResponseDTO("Boa viajem, Mãe!", sdf.parse("21/03/2018"), new AuthorResponseDTO(luccas));
        CommentResponseDTO c3 = new CommentResponseDTO("Parabéns, Luscca!!", sdf.parse("24/05/2022"), new AuthorResponseDTO(mary));

        post1.getComments().add(c2);
        post3.getComments().addAll(Arrays.asList(c1, c3));

        postRepository.saveAll(Arrays.asList(post1, post2, post3));

        mary.getPosts().add(post1);
        luccas.getPosts().addAll(Arrays.asList(post2, post3));

        userRepository.saveAll(Arrays.asList(mary, luccas));

    }
}
