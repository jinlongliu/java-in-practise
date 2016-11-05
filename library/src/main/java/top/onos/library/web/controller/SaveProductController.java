package top.onos.library.web.controller;

import top.onos.library.web.domain.Product;
import top.onos.library.web.domain.ProductForm;
import top.onos.library.web.validator.ProductValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

        //验证表单
        ProductValidator productValidator = new ProductValidator();
        List<String> errors = productValidator.validate(productForm);

        if (errors.isEmpty()) {
            //创建模型
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            product.setPrice(Float.parseFloat(productForm.getPrice()));

            //保存产品，DB持久化

            //为视图在范围变量内存储模型
            req.setAttribute("product", product);
            return "/WEB-INF/jsp/ProductDetails.jsp";
        } else {
            req.setAttribute("errors", errors);
            req.setAttribute("form", productForm);
            return "/WEB-INF/jsp/ProductForm.jsp";
        }
    }
}
