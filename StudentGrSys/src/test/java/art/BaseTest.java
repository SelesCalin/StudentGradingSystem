package art;

import art.entity.course.Course;
import art.entity.user.User;
import art.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.List;
import java.util.Set;


public class BaseTest {


    private SessionFactory sessionFactory;
    private Session session=null;

    @Before
    public void setUp(){
        sessionFactory= HibernateUtils.getSessionJavaConfigFactory();
        session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
//        List courses=session.createQuery("from Course").list();
//        for(Object o: courses) {
//            Course course = (Course) o;
//            Set users = course.getStudents();
//            for (Object object : users) {
//                User user = (User) object;
//                user.removeCourse(course);
//            }
//        }
        String[] tables={"QuizGrade","AssignmentGrade","Material","Chat","Assignment","Answer","Question","Quiz","Course","user"};
        for(String s: tables) {
            Query query = session.createQuery("DELETE FROM " + s);
            query.executeUpdate();
        }

        transaction.commit();


    }

    public Session getSession() {
        return session;
    }


}
