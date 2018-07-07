package com.dataStructure.test2;

/**
 * Created by longjinwen on 20/11/2017.
 */
public interface Stack {
    public int getSize();
    public Object top() throws Exception;
    public boolean isEmpty();
    public void push(Object ele) throws Exception;
    public Object pop() throws Exception;
}
