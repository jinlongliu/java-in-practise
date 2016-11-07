package top.onos.library.web.service;

import top.onos.library.web.domain.Student;

import java.util.List;

/**
 * Created by Liu on 2016/11/7.
 */
public interface StudentService {
    List<Student> findAllStudnets();

    Student findStudentById(Integer id);

    void insertStudent(Student student);

    List<Student> findAll();

    Student findById(Integer id);

    void insertOne(Student student);
}