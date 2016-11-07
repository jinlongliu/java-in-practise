package top.onos.library.web.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import top.onos.library.web.domain.Student;

import java.util.List;

/**
 * Created by Liu on 2016/11/7.
 */
public interface StudentMapper {
    List<Student> findAllStudents();

    Student findStudentById(Integer id);

    void insertStudent(Student student);

    void deleteStudent(Integer id);

    List<Student> findAllByNameEmail(String name, String email);

    /*基于注解*/
    @Insert("insert into student(name, email, dob) values (#{name},#{email},#{dob})")
    @Options(useGeneratedKeys = true, keyColumn = "studID")
    int insert(Student student);

    Student findStudentByName(String name);
}
