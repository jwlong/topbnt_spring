package com.dataStructure.quence;

/**
 * Created by longjinwen on 07/12/2017.
 */
public interface IQueue {
    /**
     * 入队
     */
    public void enQuence(Object o) throws QueueFullCapcityException;

    /**
     * 出队
     * @return
     */
    public Object deQuence() throws QueueEmptyException;// 出队

    /**
     * 得到队列长度
     * @return
     */
    public int getSize();

    /**
     * 队列是否为空
     * @return
     */
    public boolean empty();

    /**
     * 取队头元素
     * @return
     */
    public Object front();

    public void traversal();

}
