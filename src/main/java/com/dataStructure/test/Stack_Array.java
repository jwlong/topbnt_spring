package com.dataStructure.test;

/**
 * Created by longjinwen on 2017/3/1.
 */
public class Stack_Array implements Stack
{
    public final static  int CAPACITY = 1024;  // 初始容器大小
    protected  Object[] objects;
    private  int capacity;
    private int top = -1; //栈顶元素的位置
    //默认CAPACITY 大小来制定容量
    public Stack_Array(){
        this(CAPACITY);
    }
    //指定容量
    public Stack_Array (int cap){
        capacity = cap;
        objects = new Object[capacity];
    }
    public Object pop() throws StackEmptyException {
         Object elem = null ;
         if(!isEmpty()){
             elem = objects[top];
             objects[top--] = null;
         }else
             throw new StackEmptyException("栈空了!");

        return elem;
    }

    public void push(Object obj)  throws  StackFullException {
        if(getSize() == capacity){
            throw  new StackFullException("栈满了!");
        }
        top++;
        objects[top] = obj;
    }

    public boolean isEmpty() {
       if(top < 0)
           return true;
        return false;
    }

    public int getSize() {
        return (top+1);
    }

    public Object top() throws StackEmptyException {
        if(isEmpty())
            throw  new StackEmptyException("栈空了");
        return objects[top];
    }
}
