package tasktest;

import java.util.TimerTask;

/**
 * Created by longjinwen on 13/11/2017.
 */
public class Task1 extends TimerTask {
    public static int num = 100;
  //  private Lock lock = (Lock) new ReentrantReadWriteLock();
  static Object ob = "aa";
  // synchronized 方法实现
    public void run() {
        try {
            synchronized (ob){
                num -- ;
                System.out.println(" start ...now num:"+num);
            }
        }finally {

        }

    }
}
