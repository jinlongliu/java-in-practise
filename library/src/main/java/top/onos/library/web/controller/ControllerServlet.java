package top.onos.library.web.controller;

import top.onos.library.web.model.Product;
import top.onos.library.web.model.ProductForm;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Liu on 2016/11/5.
 */
public class ControllerServlet extends HttpServlet {

    private static final long serialVersionUID = -5118100201909034679L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        super.doGet(req, resp);
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
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
        if (action.equals("product_input.action")) {
            //nothing to be done
        } else if (action.equals("product_save.action")) {
            //创建表单对象
            ProductForm productForm = new ProductForm();
            //填充表单属性
            productForm.setName(req.getParameter("name"));
            productForm.setDescription(req.getParameter("description"));
            productForm.setPrice(req.getParameter("price"));

            //创建模型
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            try {
                product.setPrice(Float.parseFloat(productForm.getPrice()));
            }catch (NumberFormatException e) {

            }

            //保存产品，DB持久化

            //为视图在范围变量内存储模型
            req.setAttribute("product", product);
        }

        //转发视图
        String dispatchUrl = null;
        if (action.equals("product_input.action")) {
            dispatchUrl = "/WEB-INF/jsp/ProductForm.jsp";
        } else if (action.equals("product_save.action")) {
            dispatchUrl = "/WEB-INF/jsp/ProductDetails.jsp";
        }
        if (dispatchUrl != null) {
            RequestDispatcher rd = req.getRequestDispatcher(dispatchUrl);
            rd.forward(req, resp);
        }
    }
}
