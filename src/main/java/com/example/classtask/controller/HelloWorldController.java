package com.example.classtask.controller;

import com.example.classtask.model.UserModel;
import com.example.classtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HelloWorldController {

    private final UserService userService;

    @Autowired
    public HelloWorldController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public String createuser(@RequestBody UserModel user){
        userService.createUser(user);

        return user.getUsername() + " has been created";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }
}
