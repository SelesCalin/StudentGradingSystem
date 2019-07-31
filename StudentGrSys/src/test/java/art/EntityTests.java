package art;

import art.entity.course.assignment.Assignment;
import art.entity.course.Course;
import art.entity.user.User;
import art.entity.enumeration.RoleType;
import art.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.sql.Timestamp;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EntityTests {

    private SessionFactory sessionFactory;
    private Session session=null;



    @Before
    public void setUp(){
        sessionFactory= HibernateUtils.getSessionJavaConfigFactory();
        session=sessionFactory.openSession();
    }

    //@Test
    public void ainsertUser(){
        Transaction transaction=session.beginTransaction();
        User user = new User();
        user.setUsername("Calin");
        user.setPassword("pass");
        user.setRole(RoleType.TEACHER);
        user.setEmail("calin.seles@gmail.com");
        user.setNume("Seles Calin");
        user.setAdresa("Vlahuta");
        session.persist(user);

        transaction.commit();
        session.close();
    }


  //  @Test
    public void baddCourseTest(){
        Transaction transaction=session.beginTransaction();
        Course course=new Course();
        course.setName("Java");
        course.setDescription("Learn java");
        course.setEnrollmentKey("ab2421");
        User user= (User)session.createQuery("FROM user").list().get(0);
        course.setTeacher(user);
        session.persist(course);

        transaction.commit();

        session.close();
    }

   // @Test
    public void cuserTest(){
        Transaction transaction=session.beginTransaction();

        User user = new User();
        user.setUsername("Andreea");
        user.setPassword("deea");
        user.setRole(RoleType.STUDENT);
        user.setEmail("andreea@deea");
        user.setNume("Deea Andreea");
        user.setAdresa("acasa");
        user.setGrupa(5);
        Course course=(Course)session.createQuery("FROM Course").list().get(0);
        user.addCourse(course);

        session.persist(user);


        transaction.commit();

        session.close();


    }


   // @Test
    public void dloginTest(){

        Transaction transaction=session.beginTransaction();
        String username="Calin";
        String password="pass1";

        CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery=criteriaBuilder.createQuery(User.class);
        Root<User> userRoot=criteriaQuery.from(User.class);
        Predicate[] predicates = new Predicate[2];
        predicates[0]=criteriaBuilder.equal(userRoot.get("username"),username);
        predicates[1]=criteriaBuilder.equal(userRoot.get("password"),password);
        criteriaQuery.select(userRoot).where(predicates);
        Query<User> query = session.createQuery(criteriaQuery);
        User result=query.uniqueResult();
        System.out.println(result);
       // assertEquals("login failed",results.size(),1);

    }


    //@Test
    public void ecreateAssignmentTest(){
        Transaction transaction = session.beginTransaction();

        User user= (User)session.createQuery("FROM user").list().get(0);

        Set<Course> courses=user.getTeachedCourses();
        Course course=(Course)courses.toArray()[0];
        Assignment assignment= new Assignment();
        assignment.setDeadline(new Timestamp(System.currentTimeMillis()));
        assignment.setName("Assignment1");
        course.addAssignment(assignment);
        session.persist(assignment);

        transaction.commit();

        session.close();
    }


    //@Test
    public void fgiveGrade(){
        Transaction transaction=session.beginTransaction();

        User user= (User)session.createQuery("FROM user").list().get(0);
        Course course=(Course)session.createQuery("FROM Course").list().get(0);
        Assignment assignment=(Assignment)course.getAssignments().toArray()[0];
       // user.addAssignmentGrade(assignment,5.0,"Good enough");
        transaction.commit();
        session.close();

    }


   // @Test
    public void gdeleteAssignment(){
        Transaction transaction=session.beginTransaction();

        Assignment assignment=(Assignment)session.createQuery("FROM Assignment").list().get(0);
        session.delete(assignment);

        transaction.commit();

        session.close();


    }

    //@Test
    public void deleteChat(){
        Transaction transaction=session.beginTransaction();
        //User sender=session.get(User.class,1);
        //User receiver=session.get(User.class,2);
        //Chat chat = new Chat(sender,receiver,"Salut",new Timestamp(System.currentTimeMillis()), MessageStatus.SENT);
        //session.persist(chat);
       // sender.addSender(chat);
        //receiver.addReciver(chat);
        User user= (User)session.createQuery("FROM user").list().get(0);
        session.delete(user);
        transaction.commit();

        session.close();

    }


   // @Test
    public void listCourseStudents(){
        Transaction transaction = session.beginTransaction();
        Course course=(Course)session.createQuery("FROM Course").list().get(0);


        transaction.commit();
        for(User user:course.getStudents()) {
            System.out.println(user.getNume());
        }
        session.close();

    }

    //@Test
    public void pDeleteAssignment(){
        Transaction transaction=session.beginTransaction();

        List assignments=session.createQuery("FROM Assignment").list();
        for(Object o: assignments) {
            session.delete(o);
        }

        transaction.commit();
        session.close();
    }


   //@Test
    public void qDeleteCourse(){
        Transaction transaction=session.beginTransaction();

        List courses=session.createQuery("FROM Course").list();
        for(Object o: courses) {
            Course course=(Course) o;
            Set users =course.getStudents();
            for(Object object: users) {
                User user = (User) object;
                user.removeCourse(course);
            }
        session.delete(o);
        }

        transaction.commit();
        session.close();
    }

   // @Test
    public void zDeleteUser(){
        Transaction transaction=session.beginTransaction();
        List users =session.createQuery("FROM user").list();
        for(Object user1: users)
            session.delete(user1);
        transaction.commit();
    }

}
