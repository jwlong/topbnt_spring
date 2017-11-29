package com.dxfjyygy.dao.impl;

import com.dxfjyygy.dao.PersonDao;
import com.dxfjyygy.entity.Address;
import com.dxfjyygy.entity.Person;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by longjinwen on 2017/3/20.
 */
@Repository
@Aspect
public class PersonDaoImpl extends BaseDaoImpl implements PersonDao {

//    @Resource
//    private SessionFactory sessionFactory;
////    public void setSessionFactory(SessionFactory sessionFactory) {
////        this.sessionFactory = sessionFactory;
////    }

    public int save(Person person) {
       Session session = getSession();
       return (Integer) session.save(person);
    }

    @Override
    public <T>  Long saveObject(T obj) {
        Serializable serializable = getSession().save(obj);
        int tmp = (Integer) serializable;
        long r = tmp;
        return r;
    }

    @Override
    public <T> Integer save(T obj) {
        Serializable s = getSession().save(obj);
        return (Integer) getSession().save(obj);
    }

    //    事物传播行为介绍:
//     @Transactional(propagation=Propagation.REQUIRED) ：如果有事务, 那么加入事务, 没有的话新建一个(默认情况下)
//　　@Transactional(propagation=Propagation.NOT_SUPPORTED) ：容器不为这个方法开启事务
//　　@Transactional(propagation=Propagation.REQUIRES_NEW) ：不管是否存在事务,都创建一个新的事务,原来的挂起,新的执行完毕,继续执行老的事务
//　　@Transactional(propagation=Propagation.MANDATORY) ：必须在一个已有的事务中执行,否则抛出异常
//　　@Transactional(propagation=Propagation.NEVER) ：必须在一个没有的事务中执行,否则抛出异常(与Propagation.MANDATORY相反)
//　　@Transactional(propagation=Propagation.SUPPORTS) ：如果其他bean调用这个方法,在其他bean中声明事务,那就用事务.如果其他bean没有声明事务,那就不用事务.
//    事物超时设置:
//    @Transactional(timeout=30) //默认是30秒
//    事务隔离级别:
//    @Transactional(isolation = Isolation.READ_UNCOMMITTED)：读取未提交数据(会出现脏读, 不可重复读) 基本不使用
//　　@Transactional(isolation = Isolation.READ_COMMITTED)：读取已提交数据(会出现不可重复读和幻读)
//　　@Transactional(isolation = Isolation.REPEATABLE_READ)：可重复读(会出现幻读)
//　　@Transactional(isolation = Isolation.SERIALIZABLE)：串行化
//　　MYSQL: 默认为REPEATABLE_READ级别
//　　SQLSERVER: 默认为READ_COMMITTED
//    脏读 : 一个事务读取到另一事务未提交的更新数据
//    不可重复读 : 在同一事务中, 多次读取同一数据返回的结果有所不同, 换句话说,
//    后续读取可以读到另一事务已提交的更新数据. 相反, "可重复读"在同一事务中多次
//            读取数据时, 能够保证所读数据一样, 也就是后续读取不能读到另一事务已提交的更新数据
//    幻读 : 一个事务读到另一个事务已提交的insert数据
    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class,timeout=1,isolation= Isolation.DEFAULT)
    public void testPersist(Person person) throws Exception{
        //这里说一下openSession 与getCurrentSession的区别
        //1 openSession 在创建Session时autoCloseSessionEnabled 参数为false ,即表示 事务结束之后Session不会自动关闭，需要手动close;
        // getCurrentSession表示的时autoCloseSessionEnabled 为true ,flushBeforeCompletionEnabled都为true.
        // 并且session会同sessionFactory组成一个map以sessionFactory为主键绑定到当前线程。
        Session session = getSession();
        session.persist(person);
    }
    @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class,timeout=1,isolation= Isolation.DEFAULT)
    public void testSaveOne2Many() {
       try {
           Session session = getSession();
           Person p = new Person();
           Address a = new Address();
           a.setAddressDetail("东莞长安");
           session.persist(a);
           Set<Address> addresses = new HashSet<Address>();
           addresses.add(a);

           p.setAge(28);
           p.setName("longjinwen");
           p.setAddresses(addresses);
           session.save(p);
        //   p.getAddresses().add(a);
//           session.save(p);
//           Address a2 = new Address();
//           p.getAddresses().add(a2);
       }catch (Exception e){
           e.printStackTrace();
       }

    }

    //@Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class,timeout=1,isolation= Isolation.DEFAULT)
    public void testDoubleOne2Many() {
        try {
            Session session = getSession();
            Person p = new Person();
            Address a = new Address();
            a.setAddressDetail("changan");
          //  session.persist(a);
//            Set<Address> addresses = new HashSet<Address>();
//            addresses.add(a);
            p.setAge(28);
            p.setName("longjinwen");
            session.persist(p);
            a.setPerson(p);
            session.save(a);
            //   p.getAddresses().add(a);
//           session.save(p);
//           Address a2 = new Address();
//           p.getAddresses().add(a2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void testSaveDoubleOne2Many() {
    }

    public void updatePerson(){

    }

    @Override
    public <T> T findObject(Class<T> cls, Serializable id) {
        return super.findObject(cls, id);
    }
}
