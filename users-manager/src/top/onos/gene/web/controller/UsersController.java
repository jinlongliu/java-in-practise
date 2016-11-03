package top.onos.gene.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.onos.gene.web.model.User;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Liu on 2016/11/3.
 */
@Controller
/*作用于类级别，定义控制器主路径*/
@RequestMapping("/admin/users")
public class UsersController {
    private final User user;

    @Autowired
    public UsersController(User user) {
        this.user = user;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, User> get() {
        Map<String, User> users = new HashMap<String, User>();
        return users;
    }

    @RequestMapping(path = "/{uid}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("uid") long Userid) {
        user.setId(Userid);
        return  user;
    }

    //请求参数绑定打控制器方法参数
    @RequestMapping(method = RequestMethod.GET)
    public User getUserById2(@RequestParam("uid") long Userid2) {
        user.setId(Userid2);
        return  user;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUser(User user) {
        //Todo
    }

    //请求体绑定至控制器方法参数
    @RequestMapping(path = "/creation", method = RequestMethod.PUT)
    public void addUsers(@RequestBody String body, Writer writer) throws IOException {
        writer.write(body);
    }

    /*
    * @PathVeariable 将函数参数与URI模板中参数绑定,如果模板参数名和函数参数名一直可以
    * 不需要特别指定，适用于简单类型的参数
    *
    * @RequestParam 请求参数绑定至方法参数
    *
    * @RequestBody 方法参数绑定了HTTP请求体的值
    *
    * */

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
    }

    /*
    * @ResponseBody 返回值直接写入到HTTP响应器
    *
    * @CookieValue 方法参数和HTTP cookie值绑定
    *
    * @RequestHeader 方法参数与请求头属性绑定
    *
    *
    *
    * */



}
