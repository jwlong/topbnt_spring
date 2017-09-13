package threadTest;

import threadTest.modal.Fibonacci;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by longjinwen on 2017/4/13.
 */
public class ThreadTest {
    @Test
    public void test1(){

        for(int i=0;i<5;i++){
            Thread a = new Thread(new FirstThread("First Thread launch!!  ===>"+i));
            a.start();
        }
    }
    @Test
    public void test2(){
        for(int i=0 ;i<2; i++){
            new Thread(new Printer()).start();
        }
    }

    /**
     * 测试yield 功能
     */
    @Test
    public void test3(){
        YieldTest y1 = new YieldTest("王小明");
        YieldTest y2 = new YieldTest("张虹");
        y1.start();
        y2.start();
    }
    @Test
    public void test4(){
        int i = 0;
        System.out.println(++i);
        System.out.println(i);
    }
    @Test
    public  void test5(){
        for(int i=0;i<10;i++){
            new Thread(new SleepTest()).start();
        }

    }
    @Test
    public void test6(){
        //测试一下斐波纳契数
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=1;i<=5;i++){
            executorService.execute(new Fibonacci(i));
        }
        executorService.shutdown();
    }
    @Test
    public void test7(){
        // 直接使用Thread.start 来执行
        for(int i=1;i<=5;i++){
            //new Thread(new Fibonacci(i)).start();
            Thread t = new Thread(new Fibonacci(i));
            synchronized (t){
                    t.start();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=1;i<=5;i++){
            executorService.execute(new Fibonacci(i));
        }
        executorService.shutdown();

//        for(int i=1;i<=5;i++){
//            //new Thread(new Fibonacci(i)).start();
//            Thread t = new Thread(new Fibonacci(i));
//            synchronized (t){
//                t.start();
//            }
//        }
    }

}
