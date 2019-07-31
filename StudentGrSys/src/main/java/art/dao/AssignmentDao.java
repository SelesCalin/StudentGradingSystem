package art.dao;

import art.entity.course.assignment.Assignment;
import art.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AssignmentDao {

    private SessionFactory sessionFactory;


    public AssignmentDao(){
        sessionFactory= HibernateUtils.getSessionJavaConfigFactory();
    }


    public void insert(Assignment assignment){

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        session.persist(assignment);

        transaction.commit();

        session.close();
    }


    public Assignment findById(Integer id){

        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
       Assignment assignment = session.get(Assignment.class,id);
        transaction.commit();
        session.close();
        return assignment;
    }

}
