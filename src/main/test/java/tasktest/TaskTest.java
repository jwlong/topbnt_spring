package tasktest;

import org.junit.Test;

import java.util.Timer;

/**
 * Created by longjinwen on 13/11/2017.
 */
public class TaskTest {
    public static void main(String[] args) {
//        for (int i=0;i<5;i++){
//            Timer timer = new Timer();
//            timer.scheduleAtFixedRate(new Task2("task "+i,new ProcessNewWorkOrderTaskExecutor()),1000,4000);
//        }

        for (int i=0;i<5;i++){
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new Task2("task "+i,new ProcessHibernateQueryTaskExecutor()),1000,4000);
        }
    }
    @Test
    public void test(){
        for (int i=0;i<5;i++){
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new Task2("task "+i,new ProcessHibernateQueryTaskExecutor()),1000,4000);
        }
    }

}
