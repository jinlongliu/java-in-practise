package top.onos.library.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.onos.library.web.dao.UserDao;
import top.onos.library.web.domain.User;
import top.onos.library.web.service.UserService;

/**
 * Created by Liu on 2016/11/7.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }
}
