package com.spring.ex.controller;

import com.spring.ex.form.LoginForm;
import com.spring.ex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login",consumes = "application/json", produces = "application/json")
    public String login(@RequestBody LoginForm loginForm) {

        return  userService.login(loginForm);

    }

    @GetMapping("/test")
    public @ResponseBody String testGet(){
        return "test works";
    }


    @PostMapping(value= "/register",consumes = "application/json", produces = "application/json")
    public void register(){

    }
}
