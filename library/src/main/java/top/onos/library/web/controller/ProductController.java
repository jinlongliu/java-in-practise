package top.onos.library.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.onos.library.web.domain.Product;
import top.onos.library.web.domain.ProductForm;

/**
 * Created by Liu on 2016/11/5.
 */
@Controller
public class ProductController {
    private static final Log logger = LogFactory.getLog(ProductController.class);

    @RequestMapping(value = "/product_input")
    public String inputProduct() {
        logger.info("inputProduct called");
        return "ProductForm2";
    }

    @RequestMapping(value = "/product_save")
    public String saveProduct(ProductForm productForm, Model model) {
        logger.info("saveProduct called");

        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try {
            product.setPrice(Float.parseFloat(productForm.getPrice()));
        } catch (NumberFormatException e) {

        }

        model.addAttribute("product", product);
        return "ProductDetails2";
    }
}
