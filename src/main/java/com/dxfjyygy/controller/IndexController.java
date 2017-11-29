package com.dxfjyygy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/11/11 0011.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        System.out.println("come in");
        return "tpl/index";
    }
}
