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
public class DoubleOne2ManyTest {
    @Resource
    private PersonService personService;
    @Test
    @Transactional
    @Rollback(false) //  若不加Rollback默认 为true
    public void test1(){
        try {
//            在基于主键的意向1-1中，在这里， person 表将作为从表，对应的person_id 参照address的主键
            //personService.testDoubleOne2Many();
            Person p = new Person();
            p.setName("name1");
            p.setAge(11);
            Address a1 = new Address();
            a1.setPerson(p);
            //personService.saveObject(p);
            int id = personService.add(p);
           // personService.add(a1);

            System.out.println("=========================================>finish");
            System.out.println("Person ID:"+id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    @Transactional
    @Rollback(false) //  若不加Rollback默认 为true
    public void test3(){
        try {
//            在基于主键的意向1-1中，在这里， person 表将作为从表，对应的person_id 参照address的主键
            //personService.testDoubleOne2Many();
            Person p = new Person();
            p.setName("name2");
            p.setAge(11);
            Address a1 = new Address();
            a1.setAddressDetail("aaaa");
            a1.setPerson(p);
            //personService.saveObject(p);
            long id = personService.save(p);
            personService.save(a1);

            System.out.println("=========================================>finish");
            System.out.println("Person ID:"+id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    @Transactional
    @Rollback(false)
    public void test2(){
       Person p =  personService.getPerson(19);
        System.out.println("Person name =====================>"+p.getName());
        for(Address a : p.getAddresses()){
            System.out.println("Address =====================>"+a.getAddressDetail());
        }
    }


    @Test
    @Transactional
    @Rollback(false)
    public void test4(){
        Person p =  personService.getPerson(19);
        System.out.println(p.getName());
        p.setAge(22);

        Set<Address> addresses = new HashSet<Address>();
        int i = 0;
        for(Address a : p.getAddresses()){
            i++;
          a.setAddressDetail("address :"+i);
          addresses.add(a);
        }
        Address a2 = new Address("中文地址test");

        a2.setPerson(p);
        addresses.add(a2);
        p.setAddresses(addresses);
        personService.save(p);
    }
}
