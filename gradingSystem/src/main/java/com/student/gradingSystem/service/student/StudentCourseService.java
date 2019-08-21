package com.student.gradingSystem.service.student;


import com.student.gradingSystem.domain.entity.User;
import com.student.gradingSystem.domain.entity.course.Course;
import com.student.gradingSystem.domain.entity.course.assignment.Assignment;
import com.student.gradingSystem.domain.entity.course.assignment.AssignmentGrade;
import com.student.gradingSystem.domain.entity.course.quiz.Quiz;
import com.student.gradingSystem.domain.entity.course.quiz.QuizGrade;
import com.student.gradingSystem.dto.course.*;
import com.student.gradingSystem.repository.CourseRepository;
import com.student.gradingSystem.repository.UserRepository;
import com.student.gradingSystem.util.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentCourseService {

    private UserRepository userRepository;
    private CourseRepository courseRepository;


    @Autowired
    public StudentCourseService(UserRepository userRepository, CourseRepository courseRepository){
        this.courseRepository=courseRepository;
        this.userRepository=userRepository;
    }

    @Transactional
    public CourseInfoDTO getCourse(Integer idStudent, Integer idCourse) throws CustomException {
        Optional<User> userOptional = userRepository.findById(idStudent);
        if (!userOptional.isPresent()) {
            throw new CustomException("User does not exist");
        }
        User user=userOptional.get();

        Optional<Course> courseOptional=courseRepository.findById(idCourse);
        if (!courseOptional.isPresent()) {
            throw new CustomException("Course does not exist");
        }
        Course course=courseOptional.get();

        Set<Course> courses=user.getCourses();
        if(!courses.contains(course))
            throw new CustomException("You are not enrolled to this course");

        CourseInfoDTO courseDTO=new CourseInfoDTO(course);

        Set<Assignment> assignments=course.getAssignments();
        List<AssignmentDTO> assignmentDTOS=new ArrayList<>();
        for(Assignment assignment: assignments) {
            AssignmentDTO assignmentDTO = new AssignmentDTO(assignment);
            List<AssignmentGrade> grades = assignment.getGradeList();
            for (AssignmentGrade grade : grades) {
                if (grade.getUser().equals(user)) {
                    assignmentDTO.setGrade(grade.getGrade());
                    assignmentDTO.setObservations(grade.getObservations());
                    break;
                }
            }

            if (System.currentTimeMillis() < assignment.getDeadline().getTime()) {
                assignmentDTO.setOpen(true);
            } else {
                assignmentDTO.setOpen(false);
            }
            assignmentDTOS.add(assignmentDTO);
        }
        courseDTO.setAssignments(assignmentDTOS);

        Set<Quiz> quizzes=course.getQuizzes();
        List<QuizInfoDTO> quizInfoDTOList=new ArrayList<>();
        for(Quiz quiz: quizzes){
            boolean taken=false;
            QuizInfoDTO quizInfoDTO=new QuizInfoDTO(quiz);
            List<QuizGrade> quizGrades= quiz.getQuizGrades();
            for(QuizGrade grade: quizGrades) {
                if (grade.getUser().equals(user)) {
                    quizInfoDTO.setGrade(grade.getGrade());
                    taken = true;
                    break;
                }
            }
            quizInfoDTO.setTaken(taken);
            quizInfoDTOList.add(quizInfoDTO);

        }

        courseDTO.setQuizzes(quizInfoDTOList);

        return courseDTO;
    }


    @Transactional
    public List<CourseDTO> getAllUnenrolledCourses(Integer id) throws CustomException {
        List<CourseDTO> courseDTOList = new ArrayList<CourseDTO>();
        List<Course> courses= courseRepository.findAll();

        Optional<User> userOptional= userRepository.findById(id);
        if(!userOptional.isPresent()) {
            throw new CustomException("User does not exist");
        }
        User user = userOptional.get();

        Set<Course> userCourses=user.getCourses();
        for(Course course: courses) {
            if (!userCourses.contains(course)) {
                courseDTOList.add(new CourseDTO(course));
            }
        }

        return  courseDTOList;
    }


    @Transactional
    public void enrollStudentTocourse(EnrollDTO enrollDTO, Integer idUser) throws CustomException{
        Optional<User> userOptional= userRepository.findById(idUser);
        if(!userOptional.isPresent()) {
            throw new CustomException("User does not exist!");
        }
        User user = userOptional.get();

        Optional<Course> optionalCourse = courseRepository.findById(enrollDTO.getId());
        if(!optionalCourse.isPresent()) {
            throw new CustomException("Course does not exist!");
        }
        Course course= optionalCourse.get();

        if(course.getEnrollmentKey().equals(enrollDTO.getEnrollmentKey())) {
            user.addCourse(course);
        }else {
            throw new CustomException("Enrollment key does not match");
        }

    }




}
