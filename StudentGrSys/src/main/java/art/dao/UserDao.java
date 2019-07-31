package art.dao;

import art.entity.course.Course;
import art.entity.user.User;
import art.entity.enumeration.RoleType;
import art.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {


    private SessionFactory sessionFactory;


    public UserDao(){
        sessionFactory= HibernateUtils.getSessionJavaConfigFactory();
    }


    public User findById(Integer id){

        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        User user = session.get(User.class,id);
        transaction.commit();
        session.close();
        return user;
    }


  public void update(User user,Object[] parameters){
        user.setUsername((String)parameters[0]);
        user.setPassword((String)parameters[1]);
        user.setRole((RoleType)parameters[2]);
        user.setNume((String)parameters[3]);
        user.setGrupa((Integer)parameters[4]);
        user.setEmail((String)parameters[5]);
        user.setAdresa((String)parameters[6]);

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.merge(user);
        transaction.commit();
        session.close();
  }


  public void insert(User user){
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        session.persist(user);

        transaction.commit();
        session.close();

  }

  public void enrollToCourse(User user, Course course){
        Session session=sessionFactory.openSession();

        Transaction transaction=session.beginTransaction();

        user.addCourse(course);
        session.merge(user);
        transaction.commit();
        session.close();
  }






}
