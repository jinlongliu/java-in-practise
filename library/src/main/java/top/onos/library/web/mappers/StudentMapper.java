package top.onos.library.web.mappers;

import top.onos.library.web.domain.Student;

import java.util.List;

/**
 * Created by Liu on 2016/11/7.
 */
public interface StudentMapper {
    List<Student> findAllStudents();

    Student findStudentById(Integer id);

    void insertStudent(Student student);
}
