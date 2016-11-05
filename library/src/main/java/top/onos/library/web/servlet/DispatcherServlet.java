package top.onos.library.web.servlet;

import top.onos.library.web.controller.InputProductController;
import top.onos.library.web.controller.SaveProductController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Liu on 2016/11/5.
 */
public class DispatcherServlet extends HttpServlet {

    /*
    * Dispatcher servlet工作：
    * 1.根据URI调用action
    * 2.实例化正确的控制类
    * 3.根据请求参数值构造表单bean
    * 4.调用控制器对象的响应方法
    * 5.转向一个视图（JSP页面）
    * */

    private static final long serialVersionUID = 1585042023529337199L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        String uri = req.getRequestURI();
        /*uri 格式/contextName/resourceName,
        *        /应用名/资源名
        * */

        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);

        //根据请求区分分发不同handler
        String dispatchUrl = null;
        /*根据URI调用正确action*/
        if (action.equals("product_input.action")) {
            //实例化控制类
            InputProductController controller = new InputProductController();
//            dispatchUrl = controller.handleRequest(req, resp);
        } else if (action.equals("product_save.action")) {
            SaveProductController controller = new SaveProductController();
            //实例化控制类
//            dispatchUrl = controller.handleRequest(req, resp);
        }

        //转发视图
        if (dispatchUrl != null) {
            RequestDispatcher rd = req.getRequestDispatcher(dispatchUrl);
            rd.forward(req, resp);
        }
    }
}
