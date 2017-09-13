package threadTest.LiftOff_modal;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by longjinwen on 2017/4/14.
 */
public class CallableTest  {
    @Test
    public void test1(){
        //ExecutorService executorService = Executors.newFixedThreadPool(1)
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            try {
                //只能通过 ExecutorService.submit(task) 来调用,返回一个Future对象
              Future<String> future =  executorService.submit(new TaskWithResult(i+1));
                String s = future.get(3, TimeUnit.SECONDS);
              if(future.isDone()){
                  System.out.println("done");
              }
              System.out.println(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
