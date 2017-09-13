package hibernateTest;

import com.dxfjyygy.entity.Address;
import com.dxfjyygy.entity.Person;
import com.dxfjyygy.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by longjinwen on 2017/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:mvc-dispatcher-servlet.xml"})
public class BasePkSingleOne2OneTest {

    @Resource
    private PersonService personService;
    @Test
    @Transactional
    @Rollback(false) //  若不加Rollback默认 为true
    public void test1(){
        //纳入事务中去 @Transactional 注解事物与session相关联在一起。在spring 中配置的
//               <bean id="transactionManager"
//               class="org.springframework.orm.hibernate4.HibernateTransactionManager">
//               <property name="sessionFactory" ref="sessionFactory"></property>
//                </bean>
//              <aop:aspectj-autoproxy />   加入横切面AOP
//               <!-- 对数据源进行事务管理 -->
//               <tx:annotation-driven transaction-manager="transactionManager" />
        Person person = new Person();
        Set<Address> list = new HashSet<Address>();
        Address address = new Address();
        address.setAddressDetail("Dong Guan");
        list.add(address);
        person.setName("longjinwen");
        //person.setAddresses(list);
        person.setAge(22);
        try {
//            在基于主键的意向1-1中，在这里， person 表将作为从表，对应的person_id 参照address的主键
            personService.testPersist(person);
            System.out.println("finish+++++++++++?");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
