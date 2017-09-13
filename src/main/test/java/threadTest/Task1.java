package threadTest;

/**
 * Created by longjinwen on 2017/4/13.
 */
public class Task1 implements  Runnable{

    public void run() {
        for(int i = 0;i<3;i++){
            System.out.println("task1 打印"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
