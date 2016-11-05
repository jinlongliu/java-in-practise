package top.onos.library.web.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.onos.library.web.domain.Product;
import top.onos.library.web.domain.ProductForm;
import top.onos.library.web.service.ProductService;

/**
 * Created by Liu on 2016/11/5.
 */
@Controller
public class ProductController {
    private static final Log logger = LogFactory.getLog(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product_input")
    public String inputProduct() {
        logger.info("inputProduct called");
        return "ProductForm2";
    }



    /*Spring MVC调动请求处理方法之前调用带@ModelAttribute注解的方法*/
    @ModelAttribute("product")
    public Product addProduct() {
        logger.info("Called before every handler function called");
        return null;
    }

    /*调用时创建Product实例，以“product”键值存入model*/
    @RequestMapping(value = "/product_submit")
    public String submitProduct(@ModelAttribute("product") Product product, Model model) {
        logger.info("submitProduct called");
        product.setName("Liu Jinlong");
        return "ProductForm3";
    }

    /*
    *
    * redirectAttributes  使用Flash属性，需要添加该参数
    * */
    @RequestMapping(value = "/product_save", method = RequestMethod.POST)
    public String saveProduct(ProductForm productForm, RedirectAttributes redirectAttributes) {
        logger.info("saveProduct called");

        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try {
            product.setPrice(Float.parseFloat(productForm.getPrice()));
        } catch (NumberFormatException e) {

        }

        //数据持久化新增
        Product saveProduct = productService.add(product);

        /*重定向经过客户端，数据会丢失，Spring 3.1提供Flash属性供重定向传值*/
        /*使用Flash属性，springmvc配置文件中要声明annotation-driven*/
        redirectAttributes.addFlashAttribute("message", "Successfully added.");

        /*避免数据二次提交*/
        /*使用重定向不便：无法轻松地传值给目标页面*/
        return "redirect:/product_view/" + saveProduct.getId();
    }


    /*
    * 传统URL参数key = value用&分隔，使用@RequestParam绑定
    * URL路径参数，用@PathVariable
    * */
    @RequestMapping(value = "/product_view/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        Product product = productService.get(id);
        model.addAttribute("product", product);
        return "ProductView";
    }

}
