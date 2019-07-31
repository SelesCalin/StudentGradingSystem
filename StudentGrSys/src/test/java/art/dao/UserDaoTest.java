package art.dao;

import art.BaseTest;
import art.entity.course.Course;
import art.entity.enumeration.RoleType;
import art.entity.user.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoTest extends BaseTest {

    private UserDao userDao;


    @Before
    public void setUp(){
        super.setUp();
        userDao=new UserDao();

    }

    @Test
    public void aTestInsert(){

        User user = new User();
        user.setUsername("Calin");
        user.setPassword("pass");
        user.setRole(RoleType.TEACHER);
        user.setEmail("calin.seles@gmail.com");
        user.setNume("Seles Calin");
        user.setAdresa("Vlahuta");

        userDao.insert(user);

        User userFromDb=userDao.findById(user.getIduser());

        assertEquals("not the same",user.getNume(),userFromDb.getNume());


    }


    @Test
    public void bTestUpdate(){

        User user=new User();
        user.setUsername("CalinUpdate");
        user.setPassword("pass");
        user.setRole(RoleType.TEACHER);
        user.setEmail("calin.seles@gmail.com");
        user.setGrupa(2);
        user.setNume("Seles Calin");
        user.setAdresa("Vlahuta");
        userDao.insert(user);

        Object[] updateParameters={"CalinUpdate","pass",RoleType.TEACHER,"calin.seles@gmail.com",6,"Seles Calin","Vlahuta"};
        userDao.update(user,updateParameters);

        User userFromDb=userDao.findById(user.getIduser());

        assertEquals("not the same",user.getGrupa(),userFromDb.getGrupa());

    }

   // @Test
    public void cTestEnroll() {
        User user = new User();
        user.setUsername("CalinAssign");
        user.setPassword("pass");
        user.setRole(RoleType.TEACHER);
        user.setEmail("calin.seles@gmail.com");
        user.setGrupa(2);
        user.setNume("Seles Calin");
        user.setAdresa("Vlahuta");
        userDao.insert(user);
        Course course = new Course();
        course.setName("Java");
        course.setDescription("Learn Java noob");
        course.setEnrollmentKey("ABC");

        CourseDao courseDao = new CourseDao();
        courseDao.insert(course);

        userDao.enrollToCourse(user, course);
        Set<Course> courses= courseDao.getAllCoursesOf(user);
        boolean bool=courses.contains(course);



    }

    @After
    public void after(){
        getSession().close();
    }

}