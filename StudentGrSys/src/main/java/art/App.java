package art;

import art.entity.User;
import art.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            List< User > userList = session.createQuery("from Student", Student.class).list();
            students.forEach(s - > System.out.println(s.getFirstName()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
}
