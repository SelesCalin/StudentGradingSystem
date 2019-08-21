package com.student.gradingSystem.controller.student;


import com.student.gradingSystem.dto.MessageDTO;
import com.student.gradingSystem.dto.course.CourseDTO;
import com.student.gradingSystem.dto.course.CourseInfoDTO;
import com.student.gradingSystem.dto.course.EnrollDTO;
import com.student.gradingSystem.service.session.Session;
import com.student.gradingSystem.service.student.StudentCourseService;
import com.student.gradingSystem.util.SessionUtil;
import com.student.gradingSystem.util.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/course")
public class StudentCoursesController {

    private StudentCourseService studentCourseService;

    @Autowired
    public StudentCoursesController(StudentCourseService studentCourseService){
        this.studentCourseService=studentCourseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getCourse(@RequestHeader("token") String token, @PathVariable Integer id){
        try {
            Integer idUser = SessionUtil.getSession(token).getUserId();
            CourseInfoDTO courseInfoDTO = studentCourseService.getCourse(idUser, id);
            return ResponseEntity.ok(courseInfoDTO);
        }catch (CustomException c) {
            return ResponseEntity.badRequest().body(new MessageDTO(c.getMessage()));
        }

    }

    @GetMapping("/enroll")
    public ResponseEntity getAllUnenrolledCourses(@RequestHeader("token") String token){
        try{
             Integer idUser= SessionUtil.getSession(token).getUserId();
            List<CourseDTO> courses= studentCourseService.getAllUnenrolledCourses(idUser);
            return ResponseEntity.ok(courses);
        }catch(CustomException c){
            return  ResponseEntity.badRequest().body(new MessageDTO(c.getMessage()));
        }
    }

    @PostMapping("/enroll")
    public ResponseEntity enrollStudentToCourse(@RequestHeader("token") String token, @RequestBody EnrollDTO enrollDTO){
        try {
            Integer idUser = SessionUtil.getSession(token).getUserId();
            studentCourseService.enrollStudentTocourse(enrollDTO, idUser);
            return ResponseEntity.ok(new MessageDTO("Success"));
        }catch (CustomException c) {
            return ResponseEntity.badRequest().body(new MessageDTO(c.getMessage()));
        }
    }

}
