package com.student.gradingSystem.controller.student;

import com.student.gradingSystem.dto.MessageDTO;
import com.student.gradingSystem.dto.StringDTO;
import com.student.gradingSystem.dto.user.StudentProfileDTO;
import com.student.gradingSystem.service.student.StudentProfileService;
import com.student.gradingSystem.util.SessionUtil;
import com.student.gradingSystem.util.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student/profile")
public class StudentProfileController {
    private StudentProfileService profileService;

    @Autowired
    public StudentProfileController(StudentProfileService profileService) {
        this.profileService = profileService;
    }


    @GetMapping
    public ResponseEntity getProfile(@RequestHeader("token") String token) {
        try {
            Integer id = SessionUtil.getSession(token).getUserId();
            StudentProfileDTO dto = profileService.getStudentProfile(id);
            return ResponseEntity.ok(dto);
        } catch (CustomException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/username")
    public ResponseEntity updateUsername(@RequestHeader("token") String token, @RequestBody String username) {
        try {
            Integer id = SessionUtil.getSession(token).getUserId();
            profileService.updateUsername(id, username);
            return ResponseEntity.ok("Username succesfully changed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/name")
    public ResponseEntity updateName(@RequestHeader("token") String token, @RequestBody StringDTO newName) {
        try {
            Integer id = SessionUtil.getSession(token).getUserId();
            profileService.updateName(id, newName.getContent());
            return ResponseEntity.ok(new MessageDTO("Name succesfully changed"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/adress")
    public ResponseEntity updateAdress(@RequestHeader("token") String token, @RequestBody String newAdress) {
        try {
            Integer id = SessionUtil.getSession(token).getUserId();
            profileService.updateAdress(id, newAdress);
            return ResponseEntity.ok(new MessageDTO("Adress succesfully changed"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/email")
    public ResponseEntity updateMail(@RequestHeader("token") String token, @RequestBody String newMail) {
        try {
            Integer id = SessionUtil.getSession(token).getUserId();
            profileService.updateEmail(id, newMail);
            return ResponseEntity.ok(new MessageDTO("E-mail succesfully changed"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/grupa")
    public ResponseEntity updateGrupa(@RequestHeader("token") String token,@RequestBody Integer newGrupa) {
        try {
            Integer id = SessionUtil.getSession(token).getUserId();
            profileService.updateGrupa(id, newGrupa);
            return ResponseEntity.ok("Grupa succesfully changed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
