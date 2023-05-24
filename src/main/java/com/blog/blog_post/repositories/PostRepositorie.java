package com.blog.blog_post.repositories;

import com.blog.blog_post.entities.Post;
import com.blog.blog_post.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Repository
public interface PostRepositorie extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text); //Query methods spring


    @Query("{'title':{ $regex: ?0, $options: 'i'} }")//Query regex mongo
    List<Post> findByTitle(String text);

    @Query("{ $and: [ { date: { $gte: ?1} }, { date: { $lte: ?2 } } ,{ $or: [ {'title':{ $regex: ?0, $options: 'i'} }, {'body':{ $regex: ?0, $options: 'i'} }, {'comments.text':{ $regex: ?0, $options: 'i'} } ] }] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
