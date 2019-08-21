package com.student.gradingSystem.controller.publ;

import com.student.gradingSystem.dto.MessageDTO;
import com.student.gradingSystem.dto.RegisterInfoDTO;
import com.student.gradingSystem.util.exception.UserRegistrationException;
import com.student.gradingSystem.service.unauthenticated.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    private UserService userService;

    @Autowired
    public RegisterController(UserService userService){
        this.userService= userService;
    }

    @PostMapping(value= "/register",consumes = "application/json", produces = "application/json")
    public ResponseEntity register(@RequestBody RegisterInfoDTO registerInfoDTO){
        try {
            System.out.println(registerInfoDTO.toString());
            Integer ok = userService.register(registerInfoDTO);
            if(ok==-1)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This username isn't available!");
            if(ok==-2)
                return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already registered");
            return ResponseEntity.ok().body(new MessageDTO("Success. You can now login"));
        }catch (UserRegistrationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
