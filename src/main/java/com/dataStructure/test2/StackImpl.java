package com.dataStructure.test2;

/**
 * Created by longjinwen on 20/11/2017.
 */
public class StackImpl implements Stack {
    static final int CAPACITY = 1024;
    protected  Object [] objs;
    int top = -1;// 栈顶元素的位置
    public StackImpl(){
        this(CAPACITY);
    }
    public StackImpl(int cap){
        objs = new Object[cap];
    }

    public int getSize() {
        return top+1;
    }

    /**
     * 得到栈顶元素
     * @return
     */
    public Object top() throws Exception {
        if(top < 0)
            throw   new Exception("空栈异常!");
        return objs[top];
    }

    public boolean isEmpty() {

        return (top < 0);
    }

    public void push(Object ele) throws Exception {
        //判断栈满没有满
        if(top > CAPACITY)
            throw new Exception("栈满异常!");
        objs[++top] = ele;
    }

    public Object pop() throws Exception {
        if(top<0)
            throw new Exception("栈空异常!");

        return objs[top--];
    }
}
