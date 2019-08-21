package com.student.gradingSystem.repository;

import com.student.gradingSystem.domain.entity.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    Course findByName(String name);
}
