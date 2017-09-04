package com.dxfjyygy.service;

import com.dxfjyygy.entity.Person;

/**
 * Created by longjinwen on 2017/2/28.
 */

public interface PersonService {

    public void testPersist(Person person) throws Exception;
    /**
     * 测试一下单向1-N  Person为一的一端
     */
    void testSaveOne2Many();
    <T> void saveObject(T obj);
    void testDoubleOne2Many();
    <T> Long save(T obj);
    Integer add(Person obj);
    Person getPerson(int i);

}
