package top.onos.library.web.controller;

import org.springframework.stereotype.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Liu on 2016/11/5.
 */
@Controller
public class CustomerController {

    @RequestMapping(value = "/customer_input")
    public String inputCustomer() {

        //Todo

        return "CustomerForm";
    }
}
