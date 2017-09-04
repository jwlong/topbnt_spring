package com.dxfjyygy.test.hibernateTest.session;

import com.dxfjyygy.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 测试一级缓存和二级缓存
 * @author longjinwen
 *
 */
public class testHibernateSession {

	public static void main(String[] args) {


//		Session session = sessionFactory.openSession();
//		Session session2 =sessionFactory.openSession();
//		System.out.println(session .equals(session2) );  //return false  openSession创建了两个新的实例
//
		Session session3 = HibernateSessionFactory.getSession();
		//Session session4 = sessionFactory.getCurrentSession();
		//System.out.println(session3 .equals(session4) );  //return false  openSession创建了两个新的实例
		//需要 jdbc事务支持
		Transaction tx = session3.beginTransaction();
		User user = (User)session3.get(User.class,1);
		System.out.println(user.getUsername());
		User user2 = (User)session3.get(User.class,1); //这个在session 中找到User 为1的数据 就在session中取回了
		//此时就是session 一级缓存的作用了。此时不再发sql 语句
		System.out.println(user2.getUsername());
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
	//缓存范围分三类
	//1:事务范围
	//2.进程范围
	//解释一下：



	//这里再来做一下总结：
	// Session级别的缓存是一级缓存，由hibernate管理 ，不需要干预，它属于事务范围的缓存
	@Test
	public  void test1(){
		Session session1 = HibernateSessionFactory.getSession();
		Transaction tx1 = session1.beginTransaction();
		User user = (User) session1.get(User.class,1);
		System.out.println(user.getUsername());
		tx1.commit();
		//提交事务，关闭session1,这个session对应的缓存也被清理。所以另加一个session后，
		//再get会再次发sql语句--即会与数据库去交互.
		HibernateSessionFactory.closeSession();
		Session session2 = HibernateSessionFactory.getSession();
		Transaction tx2 = session2.beginTransaction();
		User user2 = (User) session2.get(User.class,1);
		System.out.println(user2.getUsername());
		tx2.commit();
		HibernateSessionFactory.closeSession();

	}

	@Test
	public  void test2(){

	}
}
