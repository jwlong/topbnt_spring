package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by longjinwen on 2017/5/4.
 */
public class LockTest {
    public static void main(String[] args) {
        //final Outputter1 output = new Outputter1();
         final  Outputter output = new Outputter();
        new Thread() {
            public void run() {
                output.output("zhangsan");
            };
        }.start();
        new Thread() {
            public void run() {
                output.output("lisi");
            };
        }.start();
    }
}

class Outputter1 {
    private Lock lock = new ReentrantLock();// 锁对象
    public void output(String name) {
        // TODO 线程输出方法
        lock.lock();// 得到锁
        try {
            for(int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
        } finally {
            lock.unlock();// 释放锁
        }
    }
}

/**
 * not add lock handler
 */
class Outputter {
    public void output(String name) {
        // TODO 线程输出方法
        try {
            for(int i = 0; i < name.length(); i++) {
                Thread.sleep(100);
                System.out.print(name.charAt(i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }
}