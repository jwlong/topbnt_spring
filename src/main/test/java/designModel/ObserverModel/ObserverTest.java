package designModel.ObserverModel;


/**
 * Created by longjinwen on 09/10/2017.
 */
public class ObserverTest {
    public static void main(String[] args) {
        Product p = new Product("this is a Tv ",1110d);
        NameObserver  nameObserver = new NameObserver();
        PriceObserver priceObserver = new PriceObserver();
        p.registObserver(nameObserver);
        p.registObserver(priceObserver);
        p.setName("tv变成了狗");

        p.setPrice(11d);
    }
}
