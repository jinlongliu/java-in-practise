package top.onos.library.web.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.onos.library.web.dao.StudentDao;
import top.onos.library.web.domain.Student;
import top.onos.library.web.mappers.StudentMapper;
import top.onos.library.web.service.StudentService;
import top.onos.library.web.util.MyBatisSqlSessionFactory;

import java.util.List;

/**
 * Created by Liu on 2016/11/7.
 */
@Service
public class StudentServiceImpl implements StudentService {

    private static Log logger =
            LogFactory.getLog(StudentServiceImpl.class);

    @Autowired
    private StudentDao studentDao;

    public List<Student> findAllStudnets() {
        return null;
    }

    public Student findStudentById(Integer id) {
        return null;
    }

    public void insertStudent(Student student) {

    }

    public List<Student> findAll() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findAllStudents();
        } finally {
            sqlSession.close();
        }
    }
}
