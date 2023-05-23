package com.blog.blog_post.repositories;

import com.blog.blog_post.entities.Post;
import com.blog.blog_post.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositorie extends MongoRepository<Post, String> {
}
