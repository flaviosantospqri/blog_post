package com.blog.blog_post.services;

import com.blog.blog_post.dto.UserDTO;
import com.blog.blog_post.entities.Post;
import com.blog.blog_post.entities.User;
import com.blog.blog_post.repositories.PostRepositorie;
import com.blog.blog_post.repositories.UserRepositorie;
import jdk.jfr.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepositorie postRepositorie;

    public Post findById(String id){
        Optional<Post> post = postRepositorie.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByText(String text){
        return postRepositorie.findByTitle(text);
    }

    public List<Post> findByFullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24+60*60*1000);
        return postRepositorie.fullSearch(text, minDate, maxDate);
    }

}
