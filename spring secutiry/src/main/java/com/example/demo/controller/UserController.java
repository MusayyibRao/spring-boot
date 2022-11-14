package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

   @Autowired
   private  UserService userService;

   @PreAuthorize("hasRole('ADMIN')")
   @GetMapping("/")
   public List<User> getUsers()
   {
       return this.userService.getData();
   }

   @GetMapping("/{username}")
   public User getUsers(@PathVariable("username") String name)
   {

       return this.userService.getUser(name);
   }


   @PostMapping("/")
   public User addUser(@RequestBody User user)
   {
       return this.userService.userAdd(user);
   }
}
