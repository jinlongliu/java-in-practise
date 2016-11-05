package top.onos.library.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Liu on 2016/11/5.
 */
public class InputProductController implements Controller {
    public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
        return "/WEB-INF/jsp/ProductForm.jsp";
    }
}
