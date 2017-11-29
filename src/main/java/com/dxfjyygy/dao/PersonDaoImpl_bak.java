package com.dxfjyygy.dao;

import com.dxfjyygy.dao.impl.BaseDaoImpl;
import com.dxfjyygy.entity.Person;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by longjinwen on 2017/3/20.
 */
@Aspect
public class PersonDaoImpl_bak  extends BaseDaoImpl implements PersonDao {

    @Resource
    private SessionFactory sessionFactory;
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    public int save(Person person) {
       Session session = sessionFactory.openSession();
       return (Integer) session.save(person);
    }
    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class,timeout=1,isolation= Isolation.DEFAULT)
    public void testPersist(Person person) throws Exception{
        //这里说一下openSession 与getCurrentSession的区别
        //1 openSession 在创建Session时autoCloseSessionEnabled 参数为false ,即表示 事务结束之后Session不会自动关闭，需要手动close;
        // getCurrentSession表示的时autoCloseSessionEnabled 为true ,flushBeforeCompletionEnabled都为true.
        // 并且session会同sessionFactory组成一个map以sessionFactory为主键绑定到当前线程。
        Session session = sessionFactory.getCurrentSession();
        session.persist(person);
       // session.flush(); //flush之后才发sql语句
    }

    public void testSaveOne2Many() {

    }

    public <T> Long saveObject(T obj) {
        return null;
    }

    public void testDoubleOne2Many() {

    }

    public void updatePerson(){

    }
}
