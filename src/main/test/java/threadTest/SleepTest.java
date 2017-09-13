package threadTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by longjinwen on 2017/4/14.
 */
public class SleepTest implements Runnable {
    private Random random = new Random();
    private int rdSec = random.nextInt(10)+1;
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(rdSec);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(rdSec);
    }
}
