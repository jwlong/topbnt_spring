package com.dxfjyygy.service;

import com.dxfjyygy.entity.User;

import java.util.List;

/**
 * Created by longjinwen on 2017/3/17.
 */
public interface UserService {
    public void saveUsers(List<User> us);
    public List<User> getAllUsernames();
}
