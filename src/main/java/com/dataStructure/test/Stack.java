package com.dataStructure.test;

/**
 * Created by longjinwen on 2017/3/1.
 */
public interface Stack {
    public Object pop() throws StackEmptyException;
    public void push(Object obj) throws  StackFullException;
    public  boolean isEmpty();
    public int getSize();
    public Object top() throws StackEmptyException;
}
