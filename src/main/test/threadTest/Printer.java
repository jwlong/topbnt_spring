package com.dxfjyygy.test.threadTest;

/**
 * Created by longjinwen on 2017/4/13.
 */
public class Printer implements Runnable {
    private static int taskCount;
    public  final int id =  taskCount++;
    public Printer(){
        System.out.println("Print started, ID ="+id);
    }
    public void run() {
        System.out.println(" stage 1 .... ID ="+id);
        Thread.yield();
        System.out.println(" stage 2 .... ID ="+id);
        Thread.yield();
        System.out.println(" stage 3 .... ID ="+id);
        Thread.yield();
    }
}
