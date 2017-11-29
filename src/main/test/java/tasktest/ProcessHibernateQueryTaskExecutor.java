package tasktest;

import com.dxfjyygy.entity.User;
import hibernateTest.session.HibernateSessionFactory;
import hibernateTest.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * Created by longjinwen on 13/11/2017.
 */
public class ProcessHibernateQueryTaskExecutor  implements  TaskExecutor{
    public void execute() throws Exception {
        Session session = HibernateSessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createSQLQuery("select * from m_User where id=1 ").addEntity(User.class);
        User user = (User) query.uniqueResult();
        if(user == null){
            user = new User();
            user.setCreateTime(new Date());
            user.setUsername("jwlong");
            user.setPasswd("lllongjin");
            session.save(user);
        }else{
            System.out.println(user.getUsername());
        }

        tx.commit();
        HibernateSessionFactory.closeSession();
    }
}
