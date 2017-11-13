package tasktest;

/**
 * Created by longjinwen on 13/11/2017.
 */
public class ProcessNewWorkOrderTaskExecutor implements TaskExecutor {
    static int num = 100;
    static Object object = "lock";

    /**
     * 同步锁使用,存在效率问题
     * @throws Exception
     */
    public void execute() throws Exception {
        synchronized (object){
            num --;
            System.out.println("ProcessNewWorkOrderTaskExecutor execute...num:"+num);
        }
    }

//        private static AtomicInteger num2 = new AtomicInteger(0);
//        public void execute() throws Exception {
//
//            //因为无法保证打印的同步与否
//            synchronized (this){
//                System.out.println("ProcessNewWorkOrderTaskExecutor execute...num2:==========>"+num2.getAndIncrement());
//            }
//    }

        //测试数据库的执行


}
