package top.onos.library.web.model;

import java.io.Serializable;

/**
 * Created by Liu on 2016/11/5.
 */
public class Product implements Serializable{
    private static final long serialVersionUID = -7361761460703009576L;
    private String name;
    private String description;
    private float price;

/*    public Product() {
    }

    public Product(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public static void main(String args[]) {
        Product product = new Product();
        System.out.println(product);
    }
}
