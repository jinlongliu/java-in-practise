package top.onos.library.web.dao;

import top.onos.library.web.domain.Student;

import java.util.List;

/**
 * Created by Liu on 2016/11/7.
 */
public interface StudentDao {
    List<Student> findAllStudnets();

    Student findStudentById(Integer id);

    void insertStudent(Student student);
}
