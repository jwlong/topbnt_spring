package designModel.ObserverModel.JMS;

import java.util.Observable;

/**
 * Created by longjinwen on 10/10/2017.
 * Topic被设计成被观察者
 */
public class Topic extends Observable {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyObservers(title);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyObservers(content);
    }
}
