package com.dxfjyygy.test.threadTest.LiftOff_modal;

import java.util.concurrent.Callable;

/**
 * Created by longjinwen on 2017/4/14.
 */
public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    public String call() throws Exception {
        return "result of TaskWithResult "+id;
    }
}
