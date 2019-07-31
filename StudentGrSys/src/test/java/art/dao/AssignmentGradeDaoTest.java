package art.dao;

import art.BaseTest;
import art.entity.course.Course;
import art.entity.course.assignment.Assignment;
import art.entity.course.assignment.AssignmentGrade;
import art.entity.enumeration.RoleType;
import art.entity.user.User;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.*;

public class AssignmentGradeDaoTest extends BaseTest {

    private AssignmentGradeDao assignmentGradeDao;



    @Before
    public void setUp(){
        super.setUp();
        assignmentGradeDao=new AssignmentGradeDao();
    }


    @Test
    public void testGetAverage(){
        User user = new User("User1", "pass1", RoleType.TEACHER, "User1", 0, "email1", "adrsa1");
        User user1 = new User("User2", "pass1", RoleType.STUDENT, "User2", 1, "email2", "adrsa2");
        User user2 = new User("User3", "pass2", RoleType.STUDENT, "User3", 1, "email3", "adrsa3");
        UserDao userDao=new UserDao();
        userDao.insert(user);
        userDao.insert(user1);
        userDao.insert(user2);

        Course course=new Course("Mate","abc",user,"en12");


        CourseDao courseDao=new CourseDao();
        courseDao.insert(course);

        userDao.enrollToCourse(user1,course);
        userDao.enrollToCourse(user2,course);

        Assignment assignment=new Assignment("assignment1",course,new Timestamp(System.currentTimeMillis()));
        Assignment assignment1=new Assignment("assignment2",course,new Timestamp(System.currentTimeMillis()));

        AssignmentDao assignmentDao=new AssignmentDao();
        assignmentDao.insert(assignment);
        assignmentDao.insert(assignment1);

        assignmentGradeDao.insert(user1,assignment,5.0,"obs");
        assignmentGradeDao.insert(user1,assignment1,10.0,"obs2");
        Double result=assignmentGradeDao.getAverage(user1);

        assertEquals(new Double(7.5),result);
    }
}