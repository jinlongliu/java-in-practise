package top.onos.library.web.service;

import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import top.onos.library.web.domain.Student;
import top.onos.library.web.service.impl.StudentServiceImpl;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Liu on 2016/11/7.
 */
@FixMethodOrder(MethodSorters.JVM)
public class StudentServiceTest {

    private static final Log logger = LogFactory.getLog(StudentServiceTest.class);

    private static StudentServiceImpl studentService;

    @BeforeClass
    public static void setup() {
        studentService = new StudentServiceImpl();
    }

    @AfterClass
    public static void teardown() {
        studentService = null;
    }

    @Test
    public void testFindAll() {
        Assert.assertNotNull(studentService);
        List<Student> students = studentService.findAll();
        Assert.assertNotNull(students);
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("This is a test method");
    }

    @Test
    public void testInserOne() {
        Student student = new Student();
        int i = 100;
        student.setStudID(i);
        student.setName("Tian");
        student.setEmail("today@qq.com");
        student.setDob(new Date());
        studentService.insertOne(student);
        Student student1 = studentService.findById(i);
        Assert.assertNotNull(student1);
        System.out.println(student1.toString());
    }

    @Test
    public void testFindOne() {
        Student student = studentService.findById(100);
        Assert.assertNotNull(student);
        logger.info(student.toString());
    }

    @Test
    public void testDeleteOne(){
        studentService.deleteOne(100);
//        Student student = studentService.findById(100);
    }


}
