package com.dxfjyygy.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by longjinwen on 28/09/2017.
 */
@Repository
public class MessageDaoImpl extends  BaseDaoImpl implements  MessageDao {
    public Integer save(Object o) {
        return (Integer) getSession().save(o);
    }
}
