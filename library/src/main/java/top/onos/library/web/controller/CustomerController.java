package top.onos.library.web.controller;

import org.springframework.stereotype.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Liu on 2016/11/5.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping(value = "/customer_input")
    public String inputCustomer() {

        //Todo

        return "CustomerForm";
    }


    /*请求处理方法可以返回的类型对象：
    * 1.ModelAndView
    * 2.Model
    * 3.Map包含模型的属性
    * 4.View
    * 5.代表逻辑视图名的String
    * 6.void
    * 7.提供对Servlet的访问，以响应HTTP头部或者内容HttpEntity或ResponseEntity对象
    * 8.Callable
    * 9.DeferredResult
    * 10.其它任意类型，Spring将其视作输出给View的对象模型*/
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteCustomer(HttpSession session) {
        //do something here
        return "Success";
    }
}
