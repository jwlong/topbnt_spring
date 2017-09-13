package localeZoneTime;
import java.util.Date;

/**
 * Created by longjinwen on 10/5/2017.
 */
public class Test {
    @org.junit.Test
    public void test1(){
        Object obj = new java.sql.Date(new Date().getTime());
        Date date  = new Date();
        //date.getTime()
        System.out.println(obj.toString());
        System.out.println(date.toString());
    }
}
