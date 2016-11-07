package top.onos.library.web.domain;

import com.google.common.base.Objects;

import java.util.Date;

/**
 * Created by Liu on 2016/11/7.
 */
public class Student {

    private Integer studID;
    private String name;
    private String email;
    private Date dob;

    public Integer getStudID() {
        return studID;
    }

    public void setStudID(Integer studID) {
        this.studID = studID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("studID", studID)
                .add("name", name)
                .add("email", email)
                .add("dob", dob)
                .toString();
    }
}
