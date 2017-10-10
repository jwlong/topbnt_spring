package designModel.ObserverModel;

import javax.swing.*;

/**
 * Created by longjinwen on 09/10/2017.
 * 观察者
 */
public class NameObserver implements Observer{

    public void update(ObServable o, Object arg) {
        if(arg instanceof String){
            String name = (String)arg;
            JFrame f = new JFrame("观察者");
            JLabel l = new JLabel("名字改变为："+name);
            f.add(l);
            f.pack();
            f.setVisible(true);
            System.out.println("名称观察者："+o+ "物品名称已经改变为："+name);
        }
    }
}
