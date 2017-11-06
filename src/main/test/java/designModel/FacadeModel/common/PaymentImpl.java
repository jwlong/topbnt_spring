package designModel.FacadeModel.common;

/**
 * Created by longjinwen on 27/10/2017.
 */
public class PaymentImpl implements Payment {
    public   String pay(){
        String food = "快餐";
        System.out.println("消费者已经向收银员支付了费用，购买的食物是:"+food);
        return food;
    }
}
