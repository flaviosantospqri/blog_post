package com.blog.blog_post.resources;

import com.blog.blog_post.entities.Post;
import com.blog.blog_post.resources.Utils.URL;
import com.blog.blog_post.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/titleSearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = postService.findByText(text);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/fullSearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
    )
    {
        text = URL.decodeParam(text);
        Date min = URL.convertInstant(minDate, new Date(0L));
        Date max = URL.convertInstant(minDate, new Date());
        List<Post> list = postService.findByFullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }
}
