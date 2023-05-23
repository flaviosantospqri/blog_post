package com.blog.blog_post.config;

import com.blog.blog_post.entities.User;
import com.blog.blog_post.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepositorie userRepositorie;

    @Override
    public void run(String... args) throws Exception {

        userRepositorie.deleteAll(); //Limpa o Banco

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepositorie.saveAll(Arrays.asList(maria, alex, bob));
    }
}
