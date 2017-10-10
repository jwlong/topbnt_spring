package aopTest;

import com.dxfjyygy.controller.PersonController;
import com.dxfjyygy.entity.Person;
import com.dxfjyygy.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by longjinwen on 01/09/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:mvc-dispatcher-servlet.xml"})
//@WebAppConfiguration
public class T1 {
    private Logger logger = LoggerFactory.getLogger(T1.class);

    @Autowired
    private PersonController personController;
    @Autowired
    private PersonService personService;

    private MockMvc mockMvc; //主要是为了模拟test controller


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
    }
    @Test
    @Transactional
    @Rollback(false) //  若不加Rollback默认 为true
    public void test1(){
        Person person = new Person();
        person.setAge(12);
        person.setName("testAOP");
        personService.add(person);
    }
    @Test
    @Transactional
    public void  testContoller1() throws Exception {
       // mockMvc.perform(get("/add"));
        mockMvc.perform(post("/test/add"))
                .andExpect(status().isOk());

    }

}
