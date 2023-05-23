package com.blog.blog_post.services;

import com.blog.blog_post.dto.UserDTO;
import com.blog.blog_post.entities.Post;
import com.blog.blog_post.entities.User;
import com.blog.blog_post.repositories.PostRepositorie;
import com.blog.blog_post.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
