package com.student.gradingSystem.service.admin;

import com.student.gradingSystem.dto.course.AssignTeacherToCourseDTO;
import com.student.gradingSystem.dto.course.CourseDTO;
import com.student.gradingSystem.domain.entity.User;
import com.student.gradingSystem.domain.entity.course.Course;
import com.student.gradingSystem.domain.entity.enumeration.RoleType;
import com.student.gradingSystem.repository.CourseRepository;
import com.student.gradingSystem.repository.UserRepository;
import com.student.gradingSystem.util.exception.CourseInsertException;
import com.student.gradingSystem.util.exception.CourseNotFoundException;
import com.student.gradingSystem.util.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class CourseServiceAdmin {
    private CourseRepository courseRepository;
    private UserRepository userRepository;

    @Autowired
    public CourseServiceAdmin(CourseRepository courseRepository, UserRepository userRepository){
        this.courseRepository = courseRepository;
        this.userRepository=userRepository;
    }

    public List<CourseDTO> getAllCourses(){
        List<Course> courses= courseRepository.findAll();
        List<CourseDTO> courseDTOList=new ArrayList<>();
        courses.forEach(course -> courseDTOList.add(new CourseDTO(course)));
        return  courseDTOList;
    }

    public void insertCourse(CourseDTO courseDTO) throws CourseInsertException {
        User user = userRepository.findByUsername(courseDTO.getTeacherUsername());
        if (user==null || user.getRole().ordinal()!=1) {
            throw new CourseInsertException("Invalid Teacher");
        }
        Course course=new Course();
        course.setTeacher(user);
        course.setDescription(courseDTO.getDescription());
        course.setEnrollmentKey(courseDTO.getEnrollmentKey());
        course.setName(courseDTO.getName());
        courseRepository.save(course);
    }

    public CourseDTO getCourse(Integer id) throws  CourseNotFoundException {
        Optional<Course> course = courseRepository.findById(id);
        CourseDTO dto;
        if(course.isPresent()) {
            Course course1 = course.get();
             dto = new CourseDTO(course1);
        }else {
            throw new CourseNotFoundException("Course not found");
        }
        return dto;
    }

    public void assignToCourse(AssignTeacherToCourseDTO teacherToCourseDTO) throws CustomException {
        Optional<User> user = userRepository.findById(teacherToCourseDTO.getIdTeacher());
        if(!user.isPresent()) {
            throw new CustomException("User not found");
        }
        Optional<Course> course= courseRepository.findById(teacherToCourseDTO.getIdCourse());
        if(!course.isPresent()) {
            throw new CustomException("Course not found");
        }
        if(user.get().getRole()!= RoleType.TEACHER){
            throw new CustomException("The selected user is not a teacher");
        }
        user.get().addCourse(course.get());
        course.get().setTeacher(user.get());
    }

    @Transactional
    public void deleteCourse(Integer id) throws CustomException {
        Optional<Course> course= courseRepository.findById(id);
        if(!course.isPresent()) {
            throw new CustomException("Course not found");
        }
        Set<User> students=course.get().getStudents();
        for(User student: students){
            student.removeCourse(course.get());
        }
        courseRepository.delete(course.get());
        

    }
}
