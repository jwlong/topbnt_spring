package designModel.ObserverModel;

/**
 * Created by longjinwen on 09/10/2017.
 */
public class PriceObserver implements Observer {
    public void update(ObServable o, Object arg) {
        if(arg instanceof Double){
            System.out.println("Object:"+o+"的price属性 updated successful!");
        }
    }
}
