package threadTest.threadSync;

/**
 * Created by longjinwen on 2017/4/17.
 */
public class Creature {
    private  static long numCreated;
    public Creature() throws InterruptedException {
        System.out.println("now Count:"+numCreated);
        Thread.sleep(1000);
//        synchronized (Creature.class){
//            numCreated++;
//        }
        numCreated++;
    }
    public static  long numCreated(){
        return numCreated;
    }
}
