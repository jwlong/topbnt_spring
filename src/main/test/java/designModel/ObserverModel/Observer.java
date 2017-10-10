package designModel.ObserverModel;

/**
 * Created by longjinwen on 09/10/2017.
 * 定义观察者接口
 */
public interface Observer {
    /**
     * 观察更新操作
     */
    void update(ObServable o,Object arg);
}
