package designModel.FacadeModel.nofacadeModel;

import designModel.FacadeModel.common.*;

/**
 * Created by longjinwen on 27/10/2017.
 */
public class Customer {
    public void haveDinner(){
        Payment payment = new PaymentImpl();
        Cook cook = new CookImpl();
        Waiter waiter = new WaiterImpl();

        String food = payment.pay();
        cook.cook(food);
        waiter.serve(food);
        System.out.println("消费者开始吃"+food);
    }
}
