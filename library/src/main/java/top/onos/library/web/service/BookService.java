package top.onos.library.web.service;

import top.onos.library.web.domain.Book;
import top.onos.library.web.domain.Category;

import java.util.List;

/**
 * Created by Liu on 2016/11/6.
 */
public interface BookService {

    List<Category> getAllCategories();

    Category getCategory(int id);

    List<Book> getAllBooks();

    Book save(Book book);

    Book update(Book book);

    Book get(long id);

    long getNextId();
}
