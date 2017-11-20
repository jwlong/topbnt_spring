package concurrentTest;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by longjinwen on 15/11/2017.
 */
public class newSingleThreadExecutorTest {
    public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
       // ExecutorService executorService = Executors.newFixedThreadPool(5);
        //Thread t = new Thread(new PrintService());
        Thread t2 = new Thread(new PrintService());
        for (int i=0;i<100;i++){
//            Thread t = new Thread(new PrintService());
//            t.start();
            executorService.execute(new PrintService());
        }
        executorService.shutdown();
//    String s = "asdfasdf asdfadf中文";
//    byte [] bytes = s.getBytes("iso8859-1");
//    String s2 = new String(bytes,"utf-8");
//   // byte[] b2 = s2.getBytes("utf-8");
//       //System.out.println(new String(b2));
//        System.out.println(s2);
    }
}
