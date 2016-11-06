package top.onos.library.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import top.onos.library.web.domain.Book;
import top.onos.library.web.domain.Category;
import top.onos.library.web.service.BookService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Liu on 2016/11/6.
 */
@Controller
public class BookController {

    private static final Log logger = LogFactory.getLog(BookController.class);

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book_input")
    public String inputBook(Model model) {
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("book", new Book());
        return "BookAddForm";
    }

    /*含路径变量的请求处理方法*/
    @RequestMapping(value = "/book_edit/{id}")
    public String editBook(Model model, @PathVariable long id) {
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        Book book = bookService.get(id);
        model.addAttribute("book", book);
        return "BookEditForm";
    }

    /*含@ModelAttribute注解，自动创建对象并传递给Model*/
    @RequestMapping(value = "/book_save")
    public String saveBook(HttpServletRequest httpServletRequest,
                           @Valid @ModelAttribute Book book,
                           BindingResult bindingResult, Model model) {

        /*判断表单验证*/
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            logger.info("Code:" + fieldError.getCode() + ", object:"
                                + fieldError.getObjectName() + ", field:"
                                + fieldError.getField() + ", message:"
                                + fieldError.getDefaultMessage());
            List<Category> categories = bookService.getAllCategories();
            model.addAttribute("categories", categories);
            model.addAttribute("book", book);
            return "BookAddForm";
        }

        List<MultipartFile> files = book.getImages();
        List<String> fileNames = new ArrayList<String>();

        if (null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);

                File imageFile = new File(httpServletRequest.getServletContext()
                                                  .getRealPath("/image"), fileName);
                try {
                    multipartFile.transferTo(imageFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.save(book);
        return "redirect:/book_list";
    }

    @RequestMapping(value = "/book_update")
    public String updateBook(@ModelAttribute Book book) {
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.update(book);
        return "redirect:/book_list";
    }

    @RequestMapping(value = "/book_list")
    public String listBooks(Model model) {
        logger.info("book_list");
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);

        Book bookForJSTL = new Book();
        bookForJSTL.setTitle("JSTL Test");
        bookForJSTL.setPublishDate(new Date());
        model.addAttribute("bookForJSTL", bookForJSTL);

        return "BookList";
    }


}
