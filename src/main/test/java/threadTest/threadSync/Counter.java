package threadTest.threadSync;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by longjinwen on 2017/4/17.
 * 以一个计数器为例子
 */

public class Counter {
    //private   static  volatile int count ; // volatile  并不能保证原子操作
    private static int count; //
    static AtomicInteger atomic = new AtomicInteger(0);
    public   synchronized   static void inc()  {
       // Thread.sleep(1);
      //  count++;
    }

    public static void main(String[] args) {
        for(int  i=0;i<1000;i++){
            new Thread(new Runnable() {
                public  synchronized  void run() {
                       //inc();
                        atomic.incrementAndGet();
                     //  new CounterModel().inc();

                }
            }).start();
        }
        System.out.println("last count  value:"+atomic.get());
    }
}
