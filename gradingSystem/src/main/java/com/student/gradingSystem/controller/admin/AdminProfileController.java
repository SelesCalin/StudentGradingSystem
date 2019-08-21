package com.student.gradingSystem.controller.admin;


import com.student.gradingSystem.dto.user.ProfileDTO;
import com.student.gradingSystem.dto.user.TeacherProfileDTO;
import com.student.gradingSystem.service.admin.AdminProfileService;
import com.student.gradingSystem.util.SessionUtil;
import com.student.gradingSystem.util.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/profile")
public class AdminProfileController {

    private AdminProfileService adminProfileService;

    @Autowired
    public AdminProfileController(AdminProfileService adminProfileService){
        this.adminProfileService=adminProfileService;
    }

    @GetMapping
    public ResponseEntity getProfile(@RequestHeader("token") String token){
        try {
            Integer id = SessionUtil.getSession(token).getUserId();
            ProfileDTO profileDTO = adminProfileService.getAdminProfile(id);
            return ResponseEntity.ok(profileDTO);
        }catch (CustomException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/username")
    public ResponseEntity updateUsername(@RequestHeader("token") String token, @RequestBody String username) {
        try {
            Integer id = SessionUtil.getSession(token).getUserId();
            adminProfileService.updateUsername(id, username);
            return ResponseEntity.ok("Username succesfully changed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/name")
    public ResponseEntity updateName(@RequestHeader("token") String token, @RequestBody String newName) {
        try {
            Integer id = SessionUtil.getSession(token).getUserId();
            adminProfileService.updateName(id, newName);
            return ResponseEntity.ok("Name succesfully changed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/adress")
    public ResponseEntity updateAdress(@RequestHeader("token") String token, @RequestBody String newAdress) {
        try {
            Integer id = SessionUtil.getSession(token).getUserId();
            adminProfileService.updateAdress(id, newAdress);
            return ResponseEntity.ok("Adress succesfully changed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/email")
    public ResponseEntity updateMail(@RequestHeader("token") String token, @RequestBody String newMail) {
        try {
            Integer id = SessionUtil.getSession(token).getUserId();
            adminProfileService.updateEmail(id, newMail);
            return ResponseEntity.ok("E-mail succesfully changed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
