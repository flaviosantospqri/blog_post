package com.blog.blog_post.resources;

import com.blog.blog_post.entities.User;
import com.blog.blog_post.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>>  findAll(){
      List<User> users = userService.findAll();

      return ResponseEntity.ok().body(users);
    }

}
