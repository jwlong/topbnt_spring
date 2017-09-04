package com.dxfjyygy.test.hibernateTest;

import com.dxfjyygy.entity.Address;
import com.dxfjyygy.entity.Person;
import com.dxfjyygy.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.*;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Created by longjinwen on 2017/3/20.
 */



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:mvc-dispatcher-servlet.xml"})
public class Many2OneTest  {
//    @Autowired
//    private PersonService personService;
//    @Test
//    public void test1(){
//        Person person = new Person();
//        Address address = new Address();
//        address.setAddressDetail("Dong Guan");
//        person.setName("longjinwen");
//        person.setAddress(address);
//        person.setAge(22);
//        personService.save(person);
//    }
//    @Resource
//    private PersonDao personDao;
    @Resource
    private PersonService personService;
//    @Resource
//    private PersonDao personDao;
    private Logger log = LoggerFactory.getLogger(Many2OneTest.class);
    @Test
  //  @Transactional   //标明此方法需使用事务
   // @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚
    public void test2(){
        //System.out.println("hello");
        Person person = new Person();
        Address address = new Address();
        address.setAddressDetail("Dong Guan");
        person.setName("longjinwen");
//        person.setAddress(address);
        person.setAge(22);
        personService.add(person);
    }


    @Test
    @Transactional
    @Rollback(false) // 当用spring-test 时，Rollback(true)会只发SQL语句而数据不会真的和数据库交互。
    public  void testPersist(){
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
    @Test
    public void testFile(){
        String parent_path = "D:\\test";
        String child_path = "test.txt";
        String path = parent_path+"\\"+child_path;
        File file = new File(parent_path,child_path);
        System.out.println(file.exists());
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeFileContent(String filePathName,String newStr) throws IOException {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        PrintWriter pw = null;
        BufferedReader br = null;
        FileOutputStream fos = null;
        StringBuffer sb =  null;
        String tmp = "";
        try {
            fis = new FileInputStream(new File(filePathName));
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            sb = new StringBuffer();
            String fieldIn = newStr+"\r\n";
            for(int i = 0;(tmp = br.readLine()) !=null;i++){
                sb.append(tmp);
            }
            br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(fis !=null)
                fis.close();
            if(isr !=null)
                isr.close();
            if(br != null)
                br.close();
            if(fos != null)
                fos.close();
        }
    }
    @Test
    public void testLineS(){
        String line_separator = System.getProperty("line.separator");
        //assertEquals("equals","1","1");
        assertEquals("equals","1","1");
        assertEquals("equals","\r\n",line_separator); // windows system
        assertEquals("equals","\n",line_separator); // not windows system
    }
}
