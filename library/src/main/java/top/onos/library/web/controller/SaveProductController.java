package top.onos.library.web.controller;

import top.onos.library.web.domain.Product;
import top.onos.library.web.domain.ProductForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Liu on 2016/11/5.
 */
public class SaveProductController implements Controller{
    public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
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
        return "/WEB-INF/jsp/ProductDetails.jsp";
    }
}
