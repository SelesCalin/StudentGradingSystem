package art.dao;

import art.BaseTest;
import art.entity.course.Course;
import art.entity.course.material.Material;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;



public class CourseDaoTest extends BaseTest {


    private CourseDao courseDao;



    @Before
    public void setUp(){
        super.setUp();
        courseDao=new CourseDao();
    }



    @Test
    public void testAddMaterial() throws SQLException, IOException {

        Course course = new Course();
        course.setName("Java");
        course.setDescription("Learn Java noob");
        course.setEnrollmentKey("ABC");

        CourseDao courseDao=new CourseDao();
        courseDao.insert(course);


        String path="documentation/RequirementsStudentGrade.txt";
        courseDao.addMaterial(course,path);
        String path2="documentation/db_diagram.png";
        courseDao.addMaterial(course,path2);
        String path3="documentation/gradingSystemDB.sql";
        courseDao.addMaterial(course,path3);

        List<Material> materials=courseDao.getAllMaterials(course);
        for(Material material:materials) {
            System.out.println(material.getName());
        }

        Material material = materials.get(0);
        byte[] bytes=new byte[10000];
        Integer size= material.getContent().getBinaryStream().read(bytes);


        File pdfFile = new File(path);
        Long sizeReal=pdfFile.length();

        assertEquals("fail",sizeReal,new Long(size));
    }



}