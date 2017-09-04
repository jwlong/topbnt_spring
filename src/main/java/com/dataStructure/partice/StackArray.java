package com.dataStructure.partice;

/**
 * Created by longjinwen on 2017/3/2.
 */
public class StackArray implements Stack {
    public static final  int CAPACITY = 1024;
    public Object[] objects;
    private  int cap;
    protected int top = -1; //默认栈顶位置
    public StackArray(){
        objects = new Object[CAPACITY];
    }
    public StackArray(int capacity){
        this.cap = capacity;
        objects = new Object[cap];
    }
    public Object top() throws StackEmptyException {
        if(isEmpty()){
            throw  new StackEmptyException("Sorry,Stack Empty!");
        }
        return objects[top];
    }

    public Object pop() throws StackEmptyException {
        Object elem = null;
        if(!isEmpty()){
            elem = objects[top];
            objects[top--] = null;
        }else
            throw  new StackEmptyException("Sorry,Stack Empty!!");
        return elem;
    }

    public void push(Object obj) throws StackFullException {
        if (getSize() == cap){
           throw new StackFullException("Sorry ,Stack Full!!");
        }
        top++;
        objects[top] = obj;
    }

    public int getSize() {
        return (top+1);
    }

    public boolean isEmpty() {
        if(top < 0)
            return true;
        return false;
    }
}
