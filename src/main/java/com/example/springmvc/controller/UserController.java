package com.example.springmvc.controller;


import com.example.springmvc.beans.User;
import com.example.springmvc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @GetMapping("/users/userid/{id}")
    public User getUserByID(@PathVariable("id") int id)
    {
        return userDao.getUserById(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user)
    {
        return userDao.addUser(user);
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
