package tasktest;

import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by longjinwen on 13/11/2017.
 */
public class Task2 extends TimerTask {
    private String taskName;
    private  TaskExecutor executor;
    private ReentrantLock lock;
    private boolean running = false;
    public Task2(String taskName,TaskExecutor executor){
        this.taskName = taskName;
        this.executor = executor;
        this.lock = new ReentrantLock();
        this.running = false;
    }
    public void run() {
            try{
                if(running){
                    return;
                }
                running = true;
                lock.lock();
                executor.execute();
                System.out.println("current task Name:"+taskName);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
                running = false;
            }
    }
}
