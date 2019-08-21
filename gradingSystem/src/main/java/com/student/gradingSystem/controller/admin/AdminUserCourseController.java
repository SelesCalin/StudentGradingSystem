package com.student.gradingSystem.controller.admin;


import com.student.gradingSystem.dto.course.AssignTeacherToCourseDTO;
import com.student.gradingSystem.service.admin.CourseServiceAdmin;
import com.student.gradingSystem.util.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/usercourse")
public class AdminUserCourseController {
    private CourseServiceAdmin courseServiceAdmin;

    @Autowired
    public AdminUserCourseController(CourseServiceAdmin courseServiceAdmin){
        this.courseServiceAdmin=courseServiceAdmin;
    }

    @PostMapping(value="/assign")
    public ResponseEntity assignTeacherToCourse(@RequestBody AssignTeacherToCourseDTO assign){
        try {
            courseServiceAdmin.assignToCourse(assign);
            return ResponseEntity.ok("Success");
        }catch (CustomException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
