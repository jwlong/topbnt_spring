package com.dxfjyygy.test.hibernateTest.serialize;

/**
 * Created by longjinwen on 2017/4/7.
 */
public class Student5 extends Person2 {
    public transient  int studentId = 5;
    public static String studentName ;
    public Student5(){
        System.out.println("Student5");
    }
}
