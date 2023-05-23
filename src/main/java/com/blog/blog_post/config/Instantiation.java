package com.blog.blog_post.config;

import com.blog.blog_post.entities.Post;
import com.blog.blog_post.entities.User;
import com.blog.blog_post.repositories.PostRepositorie;
import com.blog.blog_post.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepositorie userRepositorie;

    @Autowired
    private PostRepositorie postRepositorie;

    @Override
    public void run(String... args) throws Exception {

        userRepositorie.deleteAll(); //Limpa o Banco
        postRepositorie.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepositorie.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, Instant.now(),  "Partiu Viagem", "Vou viajar para são paulo. Abraços!", maria);
        Post post2 = new Post(null, Instant.now(),  "Bom dia", "Acordei feliz hoje", alex);
        Post post3 = new Post(null, Instant.now(),  "Voltando para casa", "Minha viagem acaba hoje, foi muito bom", maria);

        postRepositorie.saveAll(Arrays.asList(post1, post2, post3));
    }
}
