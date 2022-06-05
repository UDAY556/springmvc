package com.example.springmvc.controller;


import com.example.springmvc.beans.User;
import com.example.springmvc.dao.UserDao;
import com.example.springmvc.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserByID(@PathVariable("id") int id)
    {
        User user = userDao.getUserById(id);

        if(user == null)
            throw new UserNotFoundException("id- "+id);

        return user;
    }

    @PostMapping("/users")
    public HttpEntity<Object> addUser(@Valid @RequestBody User user)
    {
        User user1 = userDao.addUser(user);


        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                 .path("/{id}")
                .buildAndExpand(user1.getId())
                .toUri();

       return ResponseEntity.created(location).build();
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user)
    {

        return userDao.updateUser(user);
    }

    @DeleteMapping("/users/userid/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userDao.deleteByID(id);
    }
}
