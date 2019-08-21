package com.student.gradingSystem.util.exception;

public class CourseInsertException extends  Exception{

    public  CourseInsertException (){

    }

    public CourseInsertException(String message) {
        super(message);
    }

    public CourseInsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public CourseInsertException(Throwable cause) {
        super(cause);
    }
}
