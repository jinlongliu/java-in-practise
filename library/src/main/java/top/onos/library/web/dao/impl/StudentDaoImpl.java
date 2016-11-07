package top.onos.library.web.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.onos.library.web.dao.StudentDao;
import top.onos.library.web.domain.Student;
import top.onos.library.web.mappers.StudentMapper;

import java.util.List;

/**
 * Created by Liu on 2016/11/7.
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    private static final Log logger =
            LogFactory.getLog(StudentDaoImpl.class);

    /*注入SqlSession和注入Mapper相比，推荐后者因为摆脱了对于MyBatis API的依赖*/
    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private StudentMapper studentMapper;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Student> findAllStudents() {
        return null;
    }

    public Student findStudentById(Integer id) {
        return null;
    }

    public void insertStudent(Student student) {
        /*自动注入sqlSession*/
        /*StudentMapper mapper = this.sqlSession.getMapper(StudentMapper.class);
        mapper.insertStudent(student);*/

        /*自动注入studentMapper*/
        studentMapper.insertStudent(student);
    }
}
