package com.dxfjyygy.log;

import org.slf4j.LoggerFactory;

/**
 * Created by longjinwen on 13/09/2017.
 */
public class LogTest {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        if(logger.isDebugEnabled()){
            logger.debug("test...");
        }
    }
}
