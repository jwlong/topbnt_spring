package threadTest.LiftOff_modal;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by longjinwen on 2017/4/14.
 */
public class LiffOffTest {

//    public static void main(String[] args) {
//        // 创建三个线程吧
//        for(int i=1;i<=3;i++){
//            new  Thread(new LiffOff()).start();
//        }
//    }
    @Test
    public void testNornal(){
        // 创建三个线程吧
        for(int i=1;i<=3;i++){
            new  Thread(new LiffOff()).start();
        }
    }
    @Test
    public void testExecutor1(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++){
            executorService.execute(new LiffOff());
        }
        executorService.shutdown();
    }
}
