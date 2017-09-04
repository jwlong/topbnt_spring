package com.dxfjyygy.test.threadTest.modal;

import java.util.Arrays;

/**
 * Created by longjinwen on 2017/4/15.
 */
public class Fibonacci2 implements Runnable{
    private  final int n;
    private int count;
    public Fibonacci2(int n){
        this.n = n;
    }

    private  int fib(int n){
        if(n<2)return  1;
        return fib(n-2)+fib(n-1);
    }
    private int next(){
        return fib(count++);
    }
    public void run() {
        int [] sequences = new int[n];
        for(int i= 0 ;i<n ;i++){
            sequences[i] = next();
        }
        System.out.println(Arrays.toString(sequences));

    }
}
