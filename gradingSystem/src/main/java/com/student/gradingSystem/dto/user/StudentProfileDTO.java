package com.student.gradingSystem.dto.user;

import com.student.gradingSystem.dto.course.CourseNameIdDTO;
import com.student.gradingSystem.domain.entity.User;
import com.student.gradingSystem.domain.entity.course.Course;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StudentProfileDTO extends ProfileDTO implements Serializable {
    private Integer grupa;
    private List<CourseNameIdDTO> courses ;

    public StudentProfileDTO(String username, String nume, String email, String role, String adresa, Integer grupa, List<CourseNameIdDTO> courses) {
        super(username, nume, email, role, adresa);
        this.grupa = grupa;
        this.courses = courses;
    }

    public StudentProfileDTO() {
    }

    public StudentProfileDTO(User user){
        super(user);
        this.grupa=user.getGrupa();
        courses=new ArrayList<CourseNameIdDTO>();
        Set<Course> courseSet=user.getCourses();
        for(Course course: courseSet) {
            courses.add(new CourseNameIdDTO(course));
        }
    }

    public Integer getGrupa() {
        return grupa;
    }

    public void setGrupa(Integer grupa) {
        this.grupa = grupa;
    }

    public List<CourseNameIdDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseNameIdDTO> courses) {
        this.courses = courses;
    }
}
