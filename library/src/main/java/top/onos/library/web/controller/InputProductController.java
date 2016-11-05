package top.onos.library.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Liu on 2016/11/5.
 */
public class InputProductController implements Controller {

    /*相对于注解方式，实现Controller接口的控制类只能处理一个动作*/
    private static final Log logger = LogFactory.getLog(InputProductController.class);

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse)
            throws Exception {
        logger.info("InputProductController called");
        return new ModelAndView("ProductForm");
    }
}
