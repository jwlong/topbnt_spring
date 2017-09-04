package com.dxfjyygy.service;

import com.dxfjyygy.dao.UserDao;
import com.dxfjyygy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by longjinwen on 2017/3/17.
 */
@Service
public class UserServiceImpl implements UserService{

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
    @Autowired
    private UserDao userDao;
    public void saveUsers(List<User> us) {
        for (User user :us){
            userDao.save(user);
        }
    }

    public List<User> getAllUsernames() {
        return userDao.findAll();
    }
}
