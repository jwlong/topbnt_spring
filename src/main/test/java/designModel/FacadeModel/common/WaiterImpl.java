package designModel.FacadeModel.common;

/**
 * Created by longjinwen on 27/10/2017.
 */
public class WaiterImpl implements Waiter {
    public void serve(String food) {
        System.out.println("食物："+food+" 端上来了...");
    }
}
