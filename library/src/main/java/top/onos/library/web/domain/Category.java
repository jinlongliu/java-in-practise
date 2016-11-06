package top.onos.library.web.domain;

import java.io.Serializable;

/**
 * Created by Liu on 2016/11/6.
 */
public class Category implements Serializable {

    private static final long serialVersionUID = 2049963643798280843L;

    private int id;
    private String name;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
