package hibernateTest.session;

import com.dxfjyygy.entity.Person;
import hibernateTest.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.jnlp.PersistenceService;
import java.util.List;

/**
 * Created by longjinwen on 2017/5/5.
 */
public class SessionTest {
    public static void main(String[] args) {

        Session session = HibernateSessionFactory.getSession();
        HibernateSessionFactory.beginTransaction();
        Query query =session.createSQLQuery("select * from t_person ").addEntity(Person.class);

        Person p = (Person) session.get(Person.class,2);
        System.out.println(p.getName());
        Person p2 = (Person) session.get(Person.class,2);
        System.out.println(p2.getAge());

        p2.setName("longji");
        session.update(p2);
        session.flush();
        HibernateSessionFactory.commitTransaction();
        System.out.println(p2.getName());
//        List list = query.list();
//        System.out.println(list);
//        System.out.println(session.isOpen());
    }

}
