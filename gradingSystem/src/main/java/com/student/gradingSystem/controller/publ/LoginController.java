package com.student.gradingSystem.controller.publ;

import com.student.gradingSystem.dto.LoginDTO;
import com.student.gradingSystem.dto.MessageDTO;
import com.student.gradingSystem.dto.TokenDTO;
import com.student.gradingSystem.service.session.Session;
import com.student.gradingSystem.service.unauthenticated.UserService;
import com.student.gradingSystem.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = "/login",consumes = "application/json", produces = "application/json")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
       TokenDTO token  = userService.login(loginDTO);
        if(token!=null ) {
            return ResponseEntity.ok(token);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username or password are invalid");
        }
    }

    @GetMapping("/test")
    public @ResponseBody String testGet(){
        return "test works";
    }

    @GetMapping("/student/user")
    public @ResponseBody String testStudent(){
        return "user";
    }


    @PostMapping("/logout")
    public  ResponseEntity logout(@RequestHeader("token") String token) {
        Session session = SessionUtil.getSession(token);
        if (session == null) {
            return ResponseEntity.badRequest().body("You can not log out if you are not logged in");
        } else {
            SessionUtil.invalidateSession(token);
            return ResponseEntity.ok(new MessageDTO("Successfully logged out"));
        }
    }
}
