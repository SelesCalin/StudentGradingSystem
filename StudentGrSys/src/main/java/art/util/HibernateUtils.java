package art.util;


import art.entity.chat.Chat;
import art.entity.course.Course;
import art.entity.course.material.Material;
import art.entity.course.assignment.Assignment;
import art.entity.course.assignment.AssignmentGrade;
import art.entity.course.quiz.Answer;
import art.entity.course.quiz.Question;
import art.entity.course.quiz.Quiz;
import art.entity.course.quiz.QuizGrade;
import art.entity.user.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtils {

    //XML based configuration
    private static SessionFactory sessionFactory;



    //Property based configuration
    private static SessionFactory sessionJavaConfigFactory;


    private static SessionFactory buildSessionJavaConfigFactory() {
        try {
            Configuration configuration = new Configuration();

            Properties settings = new Properties();
            settings.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/gradingsysTest?useSSL=false&allowPublicKeyRetrieval=true&useLegacyDatetimeCode=false");
            settings.put(Environment.USER,"root");
            settings.put(Environment.PASS,"artsoft");
            settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
            settings.put(Environment.SHOW_SQL,"true");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
            settings.put(Environment.HBM2DDL_AUTO,"update");
            settings.put(Environment.GLOBALLY_QUOTED_IDENTIFIERS,"true");
            configuration.setProperties(settings);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Course.class);
            configuration.addAnnotatedClass(Quiz.class);
            configuration.addAnnotatedClass(Answer.class);
            configuration.addAnnotatedClass(Assignment.class);
            configuration.addAnnotatedClass(AssignmentGrade.class);
            configuration.addAnnotatedClass(Chat.class);
            configuration.addAnnotatedClass(Material.class);
            configuration.addAnnotatedClass(Question.class);
            configuration.addAnnotatedClass(QuizGrade.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static SessionFactory getSessionJavaConfigFactory() {
        if(sessionJavaConfigFactory == null) sessionJavaConfigFactory = buildSessionJavaConfigFactory();
        return sessionJavaConfigFactory;
    }

}
