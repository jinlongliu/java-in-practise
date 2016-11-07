package top.onos.library.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import top.onos.library.web.domain.Student;
import top.onos.library.web.domain.User;
import top.onos.library.web.service.StudentService;
import top.onos.library.web.service.UserService;

import java.util.Date;

/**
 * Created by Liu on 2016/11/7.
 */
@Controller
public class UserController {
    private static final Log logger =
            LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "add_user")
    public String addUser() {
        User user = new User("Liu Jinlong", "Nanjing");
        userService.addUser(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "add_student")
    public String addStudent(@ModelAttribute Student student) {
        student.setName("Controller Insert");
        student.setEmail("789@126.com");
        student.setDob(new Date());
        studentService.insertStudentSpring(student);
        return "redirect:/login";
    }
}
