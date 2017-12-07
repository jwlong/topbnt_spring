package com.dxfjyygy.dao.impl;

import com.dxfjyygy.dao.UserDao;
import com.dxfjyygy.entity.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by longjinwen on 2017/3/17.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
    @Transactional
    public int save(User user) {
        return (Integer) sessionFactory.getCurrentSession().save(user);
    }

    public List<User> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        return criteria.list();
    }
}
