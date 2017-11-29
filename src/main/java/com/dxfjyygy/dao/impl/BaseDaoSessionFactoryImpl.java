package com.dxfjyygy.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * Created by longjinwen on 2017/3/21.
 */
public class BaseDaoSessionFactoryImpl {
    @Resource
    private SessionFactory sessionFactory;
    public Session getSession(){
        return  sessionFactory.getCurrentSession();
    }
}
