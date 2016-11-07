package top.onos.library.web.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import top.onos.library.web.dao.StudentDao;
import top.onos.library.web.domain.Student;

import java.util.List;

/**
 * Created by Liu on 2016/11/7.
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    private static final Log logger =
            LogFactory.getLog(StudentDaoImpl.class);

    private SqlSession sqlSession;

    public List<Student> findAllStudnets() {
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        return studentDao.findAllStudnets();
    }

    public Student findStudentById(Integer id) {
        return null;
    }

    public void insertStudent(Student student) {

    }
}
