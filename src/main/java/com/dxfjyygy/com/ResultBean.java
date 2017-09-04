package com.dxfjyygy.com;

import java.io.Serializable;

/**
 * Created by longjinwen on 01/09/2017.
 */
public class ResultBean<T> implements Serializable {
    public static final int SUCCESS = 0;
    public static final int FAIL = 1;
    public static final int NO_PERMISSION = 2;


    private T data;
    private int  code  = SUCCESS;
    private String msg = "success";
    public ResultBean(){
        super();
    }
    public ResultBean(T data){
        super();
        this.data = data;
    }
    public ResultBean(Throwable e){
        super();
        this.msg = e.toString();
        this.code = FAIL;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
