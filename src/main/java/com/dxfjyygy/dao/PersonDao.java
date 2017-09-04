package com.dxfjyygy.dao;

import com.dxfjyygy.entity.Person;

import java.io.Serializable;

/**
 * Created by longjinwen on 2017/3/20.
 */

public interface PersonDao extends  BaseDao {
    public int save(Person person);
    public void testPersist(Person person) throws Exception;
    void testSaveOne2Many();
    <T> Long saveObject(T obj);
    void testDoubleOne2Many();

    <T> Integer save(T obj);

    <T> T findObject(Class<T> cls, Serializable id);
}
