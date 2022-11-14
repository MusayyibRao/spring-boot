package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/all")
public class LoginController {


    @GetMapping("/register")
    public String getRegister(){
        return "Register Page........";
    }


    @GetMapping("/login")
    public String getLogin(){
        return "Login Page........";
    }

}
