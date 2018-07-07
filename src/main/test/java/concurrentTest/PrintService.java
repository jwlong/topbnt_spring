package concurrentTest;

/**
 * Created by longjinwen on 15/11/2017.
 */
public class PrintService implements  Runnable {
    private static int num = 100;
    static Object o= "a";
    public void run() {
        //System.out.println(Thread.currentThread().getName()+"num:"+num--);

        try {
            Thread.sleep(200);
           // synchronized ( o){
                System.out.println(num--);
          //  }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
