package com.dxfjyygy.test.threadTest.threadSync;

/**
 * Created by longjinwen on 2017/4/17.
 */
public class CounterModel {
    private int count = 0;
    public synchronized void inc() throws InterruptedException {
        Thread.sleep(1);
        count++;
    }
}
