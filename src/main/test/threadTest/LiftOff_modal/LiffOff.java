package com.dxfjyygy.test.threadTest.LiftOff_modal;

/**
 * Created by longjinwen on 2017/4/14.
 * 模拟火箭升空的读秒
 */
public class LiffOff implements  Runnable {
    protected  int countDown = 10; // default 10 seconds
    private static  int taskCount = 0 ;
    private final  int id = taskCount++;
    public  String status(){
        return  "#"+id+"("+(countDown > 0 ? countDown:"LiffOff!"+")");
    }
    public void run() {
        while(countDown-- > 0){
            System.out.println(status());
            Thread.yield();
        }

    }
}
