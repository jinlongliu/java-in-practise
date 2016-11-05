package top.onos.library.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import top.onos.library.web.domain.Product;
import top.onos.library.web.domain.ProductForm;
import top.onos.library.web.validator.ProductValidator;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Liu on 2016/11/5.
 */
public class SaveProductController implements Controller{

    private static final Log logger = LogFactory.getLog(SaveProductController.class);

    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("SaveProductController called");

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

            return new ModelAndView("/WEB-INF/jsp/ProductDetails.jsp", "product", product);
        } else {
            req.setAttribute("errors", errors);
            req.setAttribute("form", productForm);
            return new ModelAndView("/WEB-INF/jsp/ProductForm.jsp");
        }
    }
}
