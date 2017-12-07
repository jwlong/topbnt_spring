package com.dataStructure.quence;

/**
 * Created by longjinwen on 07/12/2017.
 */
public class QueueArrImpl implements IQueue {

    private static final int DEFAULT_CAPACITY = 100;
    int cap ;// 实际容量
    private Object[] objArr;
    private int front; //队头下标
    private int rear;//队尾下标

    public QueueArrImpl(){
     //   objArr = new Object[DEFAULT_CAPACITY];
        this(DEFAULT_CAPACITY);
    }
    public QueueArrImpl(int cap){
        this.cap = cap;
        objArr = new Object[cap];
    }
    public void enQuence(Object object) throws QueueFullCapcityException {
        if(getSize() == (cap -1)){
            throw new QueueFullCapcityException("队满了");
        }
        objArr[rear] = object;
        rear = (rear+1)%cap;
    }

    public Object deQuence() throws QueueEmptyException {
        Object element;
        if(empty()){
            throw new QueueFullCapcityException("队空了");
        }
        element = objArr[front];
        front = (front+1)%cap;
        return element;
    }

    public int getSize() {
        return (cap-front+rear)%cap;
    }

    public boolean empty() {
        return (front==rear);
    }

    public Object front() {
        if(empty()){
            throw new QueueFullCapcityException("队空了");
        }
        return objArr[front];
    }

    public void traversal() {
        for (int i = front;i<rear;i++){
            System.out.print(objArr[i] +" ");
        }
        System.out.println();
    }
}
