package com.example.springmvc.dao;


import com.example.springmvc.beans.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDao {

    private  static List<User> users = new ArrayList<>();

    private static int count = 2;

   static  {

      users.add(new User(1,"shiva"));
      users.add(new User(2,"Hari"));
   }


   public List<User> getAllUsers() {
       return  users;
   }

   public User getUserById(int id) {
       return users
               .stream()
               .filter(user -> user.getId()==id)
               .findFirst()
               .get();
   }

   public Boolean deleteByID(int id) {
       User user = getUserById(id);
       return users.remove(user);
   }

   public User addUser(User user) {

        users.add(user);

        return user;
   }

   public User updateUser(User user) {
       User user1 = getUserById(user.getId());
       user1.setName(user.getName());
       return user;
   }

}
