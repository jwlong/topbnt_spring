package hibernateTest;

import com.dxfjyygy.entity.Address;
import com.dxfjyygy.entity.Person;
import com.dxfjyygy.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by longjinwen on 2017/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:mvc-dispatcher-servlet.xml"})
public class SingleOne2OneTest {

    @Resource
    private PersonService personService;
    @Test
    @Transactional
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
        Address address = new Address();
        address.setAddressDetail("Dong Guan");
        person.setName("longjinwen");
//        person.setAddress(address);
        person.setAge(22);
        try {
            personService.testPersist(person);
            System.out.println("finish+++++++++++?");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
