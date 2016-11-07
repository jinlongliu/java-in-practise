package top.onos.library.web.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.onos.library.web.dao.UserDao;
import top.onos.library.web.domain.User;

import javax.sql.DataSource;

/**
 * Created by Liu on 2016/11/7.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addUser(User user) {
        this.jdbcTemplate.update("insert into user (name, address) values (?,?)",
                                 user.getName(),
                                 user.getAddress());
    }
}
