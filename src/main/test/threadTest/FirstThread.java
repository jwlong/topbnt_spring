package com.dxfjyygy.test.threadTest;

/**
 * Created by longjinwen on 2017/4/13.
 */
public class FirstThread implements  Runnable {
    public FirstThread(String msg){
        System.out.println(msg);
    }
    public void run() {
        for(int i= 1 ;i<3;i++){
            System.out.println("stage"+i+" print something ...."+i);
            Thread.yield();
        }
        System.out.println("end stage");

    }
}
