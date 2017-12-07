package thinkinginJava.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/10/8 0008.
 * 测试训练第6题
 * 创建一个任务 ，它将睡眠1到10秒之间的随机数量的时间
 * 然后显示它的睡眠时间并退出，创建并运行一定数据的任务
 */
public class E6
{
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        //Executors.newSingleThreadExecutor();
        //ThreadPoolExecutor executor = new ThreadPoolExecutor()
        for(int i=0;i<10;i++){
            exec.execute(new sleepTask());
        }
        exec.shutdown();
    }
}
class sleepTask implements Runnable{

    public void run() {
        try {
            int sleepTime = getRandomNum(1,10);
            //Thread.yield();
            Thread.sleep(sleepTime*1000);
            System.out.println("sleep:"+sleepTime+" second");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //get min到max秒的随机数字
    public int getRandomNum(int min,int max) throws Exception{
        int  result = 0;
        Random random = new Random();
        result = random.nextInt(max-min+1)+min;
        return result;
    }
}
