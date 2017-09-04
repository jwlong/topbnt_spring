package com.dataStructure.partice.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by longjinwen on 2017/3/2.
 */
public class ArrayListInThread implements  Runnable {
   List<String> list1 = new ArrayList();
  //  List<String> list1 = Collections.synchronizedList(new ArrayList<String>());// thread safe
    public void run() {
        try {
            Thread.sleep( (int)Math.random()*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list1.add(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("myGroup");
        ArrayListInThread t = new ArrayListInThread();
        for(int i = 0; i< 10000; i++){
            Thread th = new Thread(group,t,String.valueOf(i));
            th.start();
        }
        while (group.activeCount() > 0){
            Thread.sleep(10);
        }
        System.out.println();
        System.out.println(t.list1.size());
    }
}
