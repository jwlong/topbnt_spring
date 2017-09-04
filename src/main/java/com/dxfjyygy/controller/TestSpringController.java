package com.dxfjyygy.controller;

import org.springframework.stereotype.Controller;

import java.lang.annotation.Annotation;

/**
 * Created by longjinwen on 2017/3/18.
 */
public class TestSpringController implements Controller {
    public String value() {
        return null;
    }

    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
