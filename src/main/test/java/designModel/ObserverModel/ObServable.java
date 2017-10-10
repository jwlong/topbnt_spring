package designModel.ObserverModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by longjinwen on 09/10/2017.
 * 这个是观察者的主题对象(1的一端)
 *
 */
public abstract class ObServable {
    //用一个list 来保存 该 对象上的所有绑定的事件监听器
    List<Observer> observers = new ArrayList<Observer>();
    public void registObserver(Observer o){
        observers.add(o);
    }
    public void removeObserver(Observer o){
        observers.remove(o);
    }

    public void notifyObservers(Object value){
        for(Observer observer :observers){
            observer.update(this,value);
        }
    }

}
