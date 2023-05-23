package com.blog.blog_post.resources;

import com.blog.blog_post.dto.UserDTO;
import com.blog.blog_post.entities.User;
import com.blog.blog_post.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>>  findAll(){
      List<User> users = userService.findAll();
      List<UserDTO> list = users.stream().map(UserDTO::new).toList();
      return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO>  findAll(@PathVariable String id){
        User user = userService.findById(id);
        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping
    public ResponseEntity<Void>  insert(@RequestBody UserDTO obj){
        User user = userService.fromDTO(obj);
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  delete(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
