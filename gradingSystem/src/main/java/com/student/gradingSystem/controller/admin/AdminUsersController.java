package com.student.gradingSystem.controller.admin;


import com.student.gradingSystem.dto.MessageDTO;
import com.student.gradingSystem.dto.user.UpdateUserDTO;
import com.student.gradingSystem.dto.user.UserDTO;
import com.student.gradingSystem.service.admin.UserServiceAdmin;
import com.student.gradingSystem.util.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin/user")
public class AdminUsersController {
    private UserServiceAdmin userService;

    @Autowired
    public AdminUsersController(UserServiceAdmin userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/allusers")
    @ResponseBody
    public ResponseEntity getAllUsers() {
        try {
            List<UserDTO> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @DeleteMapping(value="/{username}")
    public ResponseEntity deleteUser(@PathVariable("username") String username) {
        Integer status = userService.delete(username);
        if (status == 1) {
            return ResponseEntity.ok("Succes");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getUser(@PathVariable Integer id) {
        try {
            UpdateUserDTO userDTO= userService.getUserUpdate(id);
            return ResponseEntity.ok(userDTO);
        } catch (UserNotFoundException ex) {
            return  ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping(value="/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody UpdateUserDTO updateDTO){
            try {
                userService.updateUser(id, updateDTO);
                return ResponseEntity.ok().body(new MessageDTO("Update successful"));
            }catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
    }
}
