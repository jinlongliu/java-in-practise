package top.onos.library.web.domain;

import java.io.Serializable;

/**
 * Created by Liu on 2016/11/7.
 */
public class Login implements Serializable {

    private static final long serialVersionUID = 3067403135867284942L;

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
