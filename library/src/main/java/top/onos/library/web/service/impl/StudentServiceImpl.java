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

    public List<Student> findAllStudents() {
        return null;
    }

    public Student findStudentById(Integer id) {
        return null;
    }

    public int insertStudent(Student student) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            int i = studentMapper.insert(student);
            /*新增数据得commit*/
            sqlSession.commit();
            return i;
        } finally {
            sqlSession.close();
        }
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

    public Student findById(Integer id) {

        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findStudentById(id);
        } finally {
            sqlSession.close();
        }
    }

    public void insertOne(Student student) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.insertStudent(student);
            /*新增数据得commit*/
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteOne(Integer id) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.deleteStudent(id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public List<Student> findAllByNameEmail(String name, String email) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findAllByNameEmail(name, email);
        } finally {
            sqlSession.close();
        }
    }

    public void insertStudentSpring(Student student) {
        studentDao.insertStudent(student);
    }
}
