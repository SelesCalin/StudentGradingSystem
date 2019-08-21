package com.student.gradingSystem.dto.user;

import com.student.gradingSystem.dto.course.CourseNameIdDTO;
import com.student.gradingSystem.domain.entity.User;
import com.student.gradingSystem.domain.entity.course.Course;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TeacherProfileDTO extends ProfileDTO implements Serializable {
    private List<CourseNameIdDTO> courses;

    public TeacherProfileDTO(String username, String nume, String email, String role, String adresa, List<CourseNameIdDTO> courses) {
        super(username, nume, email, role, adresa);
        this.courses = courses;
    }

    public TeacherProfileDTO() {
    }

    public TeacherProfileDTO(User user){
        super(user);
        courses=new ArrayList<CourseNameIdDTO>();
        Set<Course> set= user.getTeachedCourses();
        for(Course course: set) {
            courses.add(new CourseNameIdDTO(course));
        }
    }

    public List<CourseNameIdDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseNameIdDTO> courses) {
        this.courses = courses;
    }
}
