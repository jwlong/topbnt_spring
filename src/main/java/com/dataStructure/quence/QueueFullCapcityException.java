package com.dataStructure.quence;

/**
 * Created by longjinwen on 07/12/2017.
 */
public class QueueFullCapcityException extends RuntimeException {
    public QueueFullCapcityException(){
        super();
    }
    public QueueFullCapcityException(String err){
        super(err);
    }

}
