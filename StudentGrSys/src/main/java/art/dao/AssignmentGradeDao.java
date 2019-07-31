package art.dao;

import art.entity.course.assignment.Assignment;
import art.entity.course.assignment.AssignmentGrade;
import art.entity.user.User;
import art.util.HibernateUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;


public class AssignmentGradeDao {


    private SessionFactory sessionFactory;


    public AssignmentGradeDao(){ sessionFactory= HibernateUtils.getSessionJavaConfigFactory();
    }


    public Double getAverage(User user){

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Query query =session.createQuery("Select g from AssignmentGrade g inner join user u on g.user.iduser=u.iduser inner join Assignment a on g.assignment.idAssignment=a.idAssignment where u.iduser=:userid");
        query.setParameter("userid",user.getIduser());

        List grades=query.list();
        Double sum=0.0;
        for(Object grade: grades){
            sum+=((AssignmentGrade)grade).getGrade();

        }

        return sum/grades.size();
    }


    public void insert(User user, Assignment assignment, Double grade, String observations){

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        //UserDao userDao= new UserDao();
       // AssignmentDao assignmentDao = new AssignmentDao();

       // User user1=userDao.findById(user.getIduser());

      //  Assignment assignment1=assignmentDao.findById(assignment.getIdAssignment());

        assignment.addGrade(user,grade,observations);
        session.update(assignment);
        transaction.commit();

        session.close();

    }
}
