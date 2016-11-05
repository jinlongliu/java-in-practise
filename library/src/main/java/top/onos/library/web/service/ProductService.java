package top.onos.library.web.service;

import top.onos.library.web.domain.Product;

/**
 * Created by Liu on 2016/11/5.
 */
public interface ProductService {
    Product add(Product product);
    Product get(long id);
}
