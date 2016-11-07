package top.onos.library.web.service;

import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.onos.library.web.domain.Student;
import top.onos.library.web.service.impl.StudentServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Liu on 2016/11/7.
 */
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
}
