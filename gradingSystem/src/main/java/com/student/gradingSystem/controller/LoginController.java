package com.student.gradingSystem.controller;


import com.student.gradingSystem.dto.LoginDTO;
import com.student.gradingSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login",consumes = "application/json", produces = "application/json")
    public String login(@RequestBody LoginDTO loginDTO) {

        return  userService.login(loginDTO);

    }

    @GetMapping("/test")
    public @ResponseBody String testGet(){
        return "test works";
    }


    @PostMapping(value= "/register",consumes = "application/json", produces = "application/json")
    public void register(){

    }
}
