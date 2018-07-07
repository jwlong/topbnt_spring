package com.dataStructure.test2;

/**
 * Created by longjinwen on 20/11/2017.
 */
public class StackTest {
    public static void main(String[] args) throws Exception {
        Stack stack = new StackImpl(10);

        System.out.println(stack.getSize()); //现在还没有 元素所以应该是0
        stack.push(new Integer(1));
        System.out.println(stack.getSize());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.getSize());
        stack.pop();
    }
}
