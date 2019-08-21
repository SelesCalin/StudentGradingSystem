package com.student.gradingSystem.controller.admin;


import com.student.gradingSystem.dto.MessageDTO;
import com.student.gradingSystem.dto.course.CourseDTO;
import com.student.gradingSystem.service.admin.CourseServiceAdmin;
import com.student.gradingSystem.util.exception.CourseInsertException;
import com.student.gradingSystem.util.exception.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/course")
public class AdminCourseController {
    private CourseServiceAdmin courseServiceAdmin;

    @Autowired
    public AdminCourseController (CourseServiceAdmin courseServiceAdmin){
        this.courseServiceAdmin=courseServiceAdmin;
    }

    @GetMapping(value = "/allcourses")
    @ResponseBody
    public ResponseEntity getAllCourses() {
        try {
            List<CourseDTO> courses  = courseServiceAdmin.getAllCourses();
            return ResponseEntity.ok(courses);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @PostMapping(value="/newcourse")
    public ResponseEntity insertCourse(@RequestBody CourseDTO courseDTO){
        try {
            courseServiceAdmin.insertCourse(courseDTO);
            return ResponseEntity.ok("New course succesfully added");
        }
        catch (CourseInsertException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getCourse(@PathVariable Integer id) {
        try {
            CourseDTO courseDTO = courseServiceAdmin.getCourse(id);
            return ResponseEntity.ok(courseDTO);
        } catch (CourseNotFoundException ex) {
            return  ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        try {
            courseServiceAdmin.deleteCourse(id);
            return ResponseEntity.ok(new MessageDTO("Success"));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
