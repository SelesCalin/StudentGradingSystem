package art.util;


import art.entity.Course;
import art.entity.Quiz;
import art.entity.User;
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
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/gradingsys?useSSL=false&allowPublicKeyRetrieval=true&useLegacyDatetimeCode=false");
            settings.put(Environment.USER,"root");
            settings.put(Environment.PASS,"artsoft");
            settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
            settings.put(Environment.SHOW_SQL,"true");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
            settings.put(Environment.HBM2DDL_AUTO,"update");
            configuration.setProperties(settings);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Course.class);
            configuration.addAnnotatedClass(Quiz.class);
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
