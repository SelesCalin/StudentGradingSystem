package art;


import art.entity.Course;
import art.entity.Quiz;
import art.entity.User;
import art.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLOutput;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Transaction transaction = null;
        SessionFactory sessionFactory = HibernateUtils.getSessionJavaConfigFactory();
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        User user = (User)session.get(User.class,1);
        Course course= (Course)session.get(Course.class,1);
        Quiz quiz=(Quiz)session.get(Quiz.class,1);

        transaction.commit();

        System.out.println(user.getNume());
        System.out.println(course.getEnrollmentKey());
        System.out.println(quiz.getDifficulty());
        System.out.println(quiz.getCourse().getEnrollmentKey());
        session.close();

//        User user= new User();
//        user.setUsername("tralal");
//        user.setPassword("blabla");
//        System.out.println(user.getIduser());
    }
}
