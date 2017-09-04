package com.dxfjyygy.test.threadTest;

/**
 * Created by longjinwen on 2017/4/13.
 */
public class YieldTest extends  Thread {
    private  String name;
    public YieldTest(String name){
        super(name);
    }
    @Override
    public void run() {

        for(int i=0;i<50;i++){
            System.out.println("--------------"+this.getName()+"---------" +i);
            if(i == 30){
                System.out.println(" 让出CPU 让自己或者其他线程执行...");
                Thread.yield();
            }
        }
    }


}
