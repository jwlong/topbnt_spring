package com.dataStructure.quence;

/**
 * Created by longjinwen on 07/12/2017.
 */
public class QueueEmptyException extends RuntimeException {
    public QueueEmptyException(){
        super();
    }
    public QueueEmptyException(String err){
        super(err);
    }
    public QueueEmptyException(String err, Throwable t){
        super(err,t);
    }
}
