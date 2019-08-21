package com.student.gradingSystem.controller.teacher;

import com.student.gradingSystem.dto.user.TeacherProfileDTO;
import com.student.gradingSystem.service.teacher.TeacherProfileService;
import com.student.gradingSystem.util.SessionUtil;
import com.student.gradingSystem.util.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher/profile")
public class TeacherProfileController {
    private TeacherProfileService teacherProfileService;

    @Autowired
    public TeacherProfileController(TeacherProfileService teacherProfileService){
        this.teacherProfileService=teacherProfileService;
    }

    @GetMapping
    public ResponseEntity getProfile(@RequestHeader("token") String token){
        try {
            Integer id = SessionUtil.getSession(token).getUserId();
            TeacherProfileDTO dto = teacherProfileService.getTeacherProfile(id);
            return ResponseEntity.ok(dto);
        }catch (CustomException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/username")
    public ResponseEntity updateUsername(@RequestHeader("token") String token, @RequestBody String username) {
        try {
            Integer id = SessionUtil.getSession(token).getUserId();
            teacherProfileService.updateUsername(id, username);
            return ResponseEntity.ok("Username succesfully changed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/name")
    public ResponseEntity updateName(@RequestHeader("token") String token, @RequestBody String newName) {
        try {
            Integer id = SessionUtil.getSession(token).getUserId();
            teacherProfileService.updateName(id, newName);
            return ResponseEntity.ok("Name succesfully changed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/adress")
    public ResponseEntity updateAdress(@RequestHeader("token") String token, @RequestBody String newAdress) {
        try {
            Integer id = SessionUtil.getSession(token).getUserId();
            teacherProfileService.updateAdress(id, newAdress);
            return ResponseEntity.ok("Adress succesfully changed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/email")
    public ResponseEntity updateMail(@RequestHeader("token") String token, @RequestBody String newMail) {
        try {
            Integer id = SessionUtil.getSession(token).getUserId();
            teacherProfileService.updateEmail(id, newMail);
            return ResponseEntity.ok("E-mail succesfully changed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
