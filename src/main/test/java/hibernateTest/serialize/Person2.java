package hibernateTest.serialize;

/**
 * Created by longjinwen on 2017/4/7.
 */

import java.io.Serializable;

/**
 * 这个实现序列化
 */
public class Person2  implements Serializable{
    private int age =  25;
    public Person2(){
        System.out.println("Peron2");
    }
}
