package designModel.ObserverModel;

/**
 * Created by longjinwen on 09/10/2017.
 */
public class Product extends ObServable {
    // 定义两个属性
    private String name;
    private Double price;


    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyObservers(name);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
        notifyObservers(price);
    }
}
