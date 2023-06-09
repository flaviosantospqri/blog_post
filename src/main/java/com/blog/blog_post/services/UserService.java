package com.blog.blog_post.services;

import com.blog.blog_post.dto.UserDTO;
import com.blog.blog_post.entities.User;
import com.blog.blog_post.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepositorie userRepositorie;

    public List<User> findAll(){
        return userRepositorie.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepositorie.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User obj){
        return userRepositorie.insert(obj);
    }

    public void delete(String id){
        User user = findById(id);
        if(user != null){
            userRepositorie.delete(findById(id));
        }else {
            throw new ObjectNotFoundException("Object not found");
        }
    }

    public User fromDTO(UserDTO obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }
    
    public User update(User obj){
        User userNew = userRepositorie.findById(obj.getId()).get();
        updateData(userNew, obj);
        return userRepositorie.save(userNew);
    }

    private void updateData(User userNew, User obj) {
        userNew.setName(obj.getName());
        userNew.setEmail(obj.getEmail());
    }

}
