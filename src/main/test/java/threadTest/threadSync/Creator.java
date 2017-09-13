package threadTest.threadSync;

/**
 * Created by longjinwen on 2017/4/17.
 */
public class Creator {
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<10;i++){
            Creature creature = new Creature();
        }
        System.out.println(Creature.numCreated());
    }

}
