package art.dao;

import art.entity.course.Course;
import art.entity.course.material.Material;
import art.entity.user.User;
import art.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import javax.sql.rowset.serial.SerialBlob;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CourseDao {


    private SessionFactory sessionFactory;

    public CourseDao(){
        sessionFactory= HibernateUtils.getSessionJavaConfigFactory();

    }


    public Course findbyId(Integer idCourse){
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Course course = session.get(Course.class,idCourse);
        transaction.commit();
        session.close();
        return course;
    }

    public void insert(Course course){
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.persist(course);
        transaction.commit();
        session.close();
    }

    public void addMaterial(Course course, String path){

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            File pdfFile = new File(path);
            Long len = pdfFile.length();
            byte[] content = new byte[2048000];
            FileInputStream fileInputStream = new FileInputStream(pdfFile);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int bytesRead;
            while ((bytesRead = fileInputStream.read(content)) != -1) {
                byteArrayOutputStream.write(content, 0, bytesRead);

            }

            Material material = new Material();
            material.setName(path);
            material.setContent(new SerialBlob(byteArrayOutputStream.toByteArray()));
            course.addMaterial(material);
            session.update(course);
            fileInputStream.close();
            transaction.commit();
            session.close();

        }catch (Exception e) {
            e.printStackTrace();
        }


    }


    public Set<Course> getAllCoursesOf(User user){
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        User user1=session.get(User.class,user.getIduser());

        Set<Course> courses=user1.getCourses();

        transaction.commit();
        session.close();

        return courses;

    }

    public List<Material> getAllMaterials(Course course){
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Query query =session.createQuery("FROM Material m  where m.course.idCourse=:idCourse");
        query.setParameter("idCourse",course.getIdCourse());

        List materials=query.list();
        List<Material> materials1=new ArrayList<Material>(materials);

        return  materials1;

    }



}
