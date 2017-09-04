package com.dxfjyygy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by longjinwen on 2017/3/20.
 */
@Controller
@RequestMapping(value = "/test")
public class TestParamsSendController {
    @RequestMapping(value = "index")
    public String index(){
        return "test";
    }
    //test/test1?method=test1&topid=1"
    @RequestMapping(value = "/test1",params = "method=test1")
    public String test1(int id){  //名称要一样不然不能赋值上去

        System.out.println(id);
        return "test1";
    }
    @RequestMapping(value = "/test2",params = "method=test2")
    public String test2(){
        System.out.println("page from test2");
        return  "test2";
    }
}
