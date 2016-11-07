package top.onos.library.web.service.impl;

import org.springframework.stereotype.Service;
import top.onos.library.web.domain.Product;
import top.onos.library.web.service.ProductService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Liu on 2016/11/5.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private Map<Long, Product> products = new HashMap<Long, Product>();
    private AtomicLong generator = new AtomicLong();

    public ProductServiceImpl() {
        Product product = new Product();
        product.setName("JX1 Power Drill");
        product.setDescription("Liu Jinlong");
        product.setPrice(129.99F);
        add(product);
    }

    public Product add(Product product) {
        long newId = generator.incrementAndGet();
        product.setId(newId);
        products.put(newId, product);
        return product;
    }

    public Product get(long id) {
        return products.get(id);
    }
}
