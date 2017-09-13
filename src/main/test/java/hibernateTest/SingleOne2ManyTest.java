package hibernateTest;

import com.dxfjyygy.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by longjinwen on 2017/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:mvc-dispatcher-servlet.xml"})
public class SingleOne2ManyTest {

    @Resource
    private PersonService personService;
    @Test
    @Transactional
    @Rollback(false) //  若不加Rollback默认 为true
    public void test1(){
        try {
//            在基于主键的意向1-1中，在这里， person 表将作为从表，对应的person_id 参照address的主键
            personService.testSaveOne2Many();
            System.out.println("=========================================>finish");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
