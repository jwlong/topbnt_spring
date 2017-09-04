package com.dxfjyygy.controller;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by longjinwen on 2017/2/27.
 */
//这个是第二种方法，不继承QuartzJobBean
public class TesJobBeantQuartz extends QuartzJobBean{

    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz plan start ");
    }
}
