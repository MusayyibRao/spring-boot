package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


  List<User> list=new ArrayList<>();

    @Autowired
    private UserRepository userRepository;

    public UserService() {

      list.add(new User("abc","abc","abc123@gmail.com","User"));
      list.add(new User("abc","abcd","abcd123@gmail.com","User"));
    }


    public List<User> getData()
    {

        return this.userRepository.findAll();
    }


    public User getUser(String name)
    {

        return this.list.stream().filter((user)->user.getUsername().equals(name)).findAny().orElse(null);

    }



    public User userAdd(User user)
    {

        this.list.add(user);
        return user;
    }

}
