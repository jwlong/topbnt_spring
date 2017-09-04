package com.dataStructure.partice;

/**
 * Created by longjinwen on 2017/3/2.
 */
public interface Stack {
    public  Object top() throws StackEmptyException;
    public Object pop() throws StackEmptyException;
    public void push(Object obj) throws StackFullException;
    public int getSize();
    public boolean isEmpty();
}
