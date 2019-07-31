package art;


import art.dao.UserDao;
import art.entity.user.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.ServletContextAttributeExporter;


/**
 * Hello world!
 *
 */


public class App
{
    //public static void main( String[] args ) {
//        Transaction transaction = null;
//        SessionFactory sessionFactory = HibernateUtils.getSessionJavaConfigFactory();
//        Session session = sessionFactory.openSession();
//        transaction = session.beginTransaction();
//
//        User user = (User)session.get(User.class,1);
//        Course course= (Course)session.get(Course.class,1);
//        Quiz quiz=(Quiz)session.get(Quiz.class,1);
//
//        transaction.commit();
//
//        System.out.println(user.getNume());
//        System.out.println(course.getEnrollmentKey());
//        System.out.println(quiz.getDifficulty());
//        System.out.println(quiz.getCourse().getEnrollmentKey());
//        session.close();

//        User user= new User();
//        user.setUsername("tralal");
//        user.setPassword("blabla");
//        System.out.println(user.getIduser());


        //UserDao userDao= new UserDao();
        //User user=userDao.findById(3);
        //System.out.println(user.getNume());


       // ApplicationContext applicationContext = new AnnotationConfigApplicationContext();


    //}




}
