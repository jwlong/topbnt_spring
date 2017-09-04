package com.dxfjyygy.dao;

import com.dxfjyygy.entity.User;

import java.util.List;

/**
 * Created by longjinwen on 2017/3/17.
 */
public interface UserDao {
    public int  save(User user);
    public List<User> findAll();
}
