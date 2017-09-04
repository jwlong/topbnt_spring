package com.dxfjyygy.controller;

import com.dxfjyygy.com.ResultBean;
import com.dxfjyygy.entity.Person;
import com.dxfjyygy.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by longjinwen on 01/09/2017.
 */
@Controller
@RequestMapping("/test")
public class PersonController {
   private final PersonService personService;
    //使用构造注入
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public ResultBean<Integer> add(Person person){
        return  new ResultBean<Integer>(personService.add(person));
    }
}
