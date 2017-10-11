package designModel.ProxyModel.eg1;

/**
 * Created by longjinwen on 11/10/2017.
 */
public class BigImage implements Image {
    public void show() {
        try {
            //模拟装载时间
            Thread.sleep(3000);
            System.out.println("Big Image Load Success!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
