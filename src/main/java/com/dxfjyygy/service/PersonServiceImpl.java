package com.dxfjyygy.service;

import com.dxfjyygy.dao.PersonDao;
import com.dxfjyygy.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by longjinwen on 2017/2/28.
 */
@Service
public class PersonServiceImpl implements PersonService
{
//    public void setPersonDao(PersonDao personDao) {
//        this.personDao = personDao;
//    }
    @Autowired
    private PersonDao personDao;
    public Long save(Person person) {
        personDao.save(person);
        return null;
    }

    public void testPersist(Person person) throws Exception {
        personDao.testPersist(person);
    }
    public void testSaveOne2Many(){
        personDao.testSaveOne2Many();
    }

    public <T> void saveObject(T obj) {
        personDao.saveObject(obj);
    }


    public void testDoubleOne2Many() {
        personDao.testDoubleOne2Many();
    }

    public <T> Long save(T obj) {
        return personDao.saveObject(obj);
    }

    public Integer add(Person obj) {
        return 0;
    }

    public Person getPerson(int i) {
       return personDao.findObject(Person.class,i);
    }


}
