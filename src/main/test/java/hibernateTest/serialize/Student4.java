package hibernateTest.serialize;

import java.io.Serializable;

/**
 * Created by longjinwen on 2017/4/7.
 */
public  class Student4 extends People implements Serializable {
    public transient int studentId = 5;
    public static String studentName;
    public int marks ;//学生分数
    public Student4() {
        System.out.println("Student4");
    }
}
