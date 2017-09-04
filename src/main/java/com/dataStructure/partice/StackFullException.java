package com.dataStructure.partice;

/**
 * Created by longjinwen on 2017/3/2.
 */

/**
 * 栈满异常
 */
public class StackFullException extends  RuntimeException {
    public StackFullException(String err){
        super(err);
    }
}
