package com.dxfjyygy.controller;


import com.dxfjyygy.com.ResultBean;
import com.sun.xml.internal.ws.api.model.CheckedException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by longjinwen on 01/09/2017.
 */
public class ControllerAOP {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAOP.class);

    public Object handlerControllerMethod(ProceedingJoinPoint proceedingJoinPoint){
        long startTime = System.currentTimeMillis();
        ResultBean<?> resultBean = null;
        try {
            resultBean = (ResultBean<?>) proceedingJoinPoint.proceed();
            logger.info(proceedingJoinPoint.getSignature()+"user time:"+(System.currentTimeMillis() - startTime));
        }catch (Throwable e){
            e.printStackTrace();
        }
        return  resultBean;
    }
    private ResultBean<?> handlerException(ProceedingJoinPoint proceedingJoinPoint, Throwable e){
        ResultBean<?> resultBean = new ResultBean();
        if(e instanceof CheckedException){
            resultBean.setMsg(e.getLocalizedMessage());
            resultBean.setCode(ResultBean.FAIL);
        }else{
            logger.error(proceedingJoinPoint.getSignature() + " error ", e);
            resultBean.setMsg(e.toString());
            resultBean.setCode(ResultBean.FAIL);
        }
        return null;
    }
}
