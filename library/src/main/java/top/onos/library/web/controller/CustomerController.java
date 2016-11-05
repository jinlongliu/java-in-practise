package top.onos.library.web.controller;

import org.springframework.stereotype.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteCustomer() {
        //do something here
        return "Success";
    }
}
