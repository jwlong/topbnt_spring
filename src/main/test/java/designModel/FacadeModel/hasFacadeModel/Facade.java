package designModel.FacadeModel.hasFacadeModel;

import designModel.FacadeModel.common.*;

/**
 * Created by longjinwen on 27/10/2017.
 */
public class Facade {
    private Cook cook;
    private Payment payment;
    private Waiter waiter;

    public Facade() {
        this.cook =  new CookImpl();
        this.payment = new PaymentImpl();
        this.waiter = new WaiterImpl();
    }
    public void serverFood(){
        //依次调用之前的服务
        String food =payment.pay();
        cook.cook(food);
        waiter.serve(food);
    }
}
