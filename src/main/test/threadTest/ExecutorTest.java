package com.dxfjyygy.test.threadTest;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by longjinwen on 2017/4/13.
 */
public class ExecutorTest {
    @Test
    public void test1(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            executorService.execute(new Printer());
        }
        executorService.shutdown();
    }
}
