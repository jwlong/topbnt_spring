package com.dxfjyygy.controller;

import com.dxfjyygy.entity.User;
import com.dxfjyygy.service.UserService;
import com.dxfjyygy.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by longjinwen on 2017/2/8.
 */
@Controller
public class MainController {
//    @Resource(name = "personService")
//    private PersonService personService;
//    @Resource(name = "userService")
//    private UserService userService;
    @Autowired
    private  UserService userService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
      // personService.userAxe();
        return "index";
    }
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String login(HttpServletRequest request){
//      //  personService.userAxe();
//        User user = new User();
//        System.out.println(request.getParameter("username"));
//        user.setPasswd(request.getParameter("passwd"));
//        user.setUsername(request.getParameter("username"));
//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());
//        request.setAttribute("user",user);
//        List<User> list = new ArrayList<User>();
//        list.add(user);
//        userService.saveUsers(list);
//        return "login";
//    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request){
        //  personService.userAxe();
        User user = new User();
        System.out.println(request.getParameter("username"));
        user.setPasswd(request.getParameter("passwd"));
        user.setUsername(request.getParameter("username"));
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        request.setAttribute("user",user);
        List<User> list = new ArrayList<User>();
        list.add(user);
        userService.saveUsers(list);
        return "login";
    }
//    @RequestMapping(value = "/getTest",method = RequestMethod.POST)
//    public String testAjax(){
//
//    }


    private String getJSONString(HttpServletRequest request) {
        //故意构造一个数组，使返回的数据为json数组，数据更复杂些
        List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>(5);
        Map<String, Object> map1 = new HashMap<String, Object>(10);
        //可以获得ajax请求中的参数
        map1.put("a", request.getParameter("a"));
        map1.put("b", request.getParameter("b"));
        map1.put("c", request.getParameter("c"));
        datas.add(map1);
        //故意构造一个数组，使返回的数据为json数组，数据更复杂些
        Map<String, Object> map2 = new HashMap<String, Object>(10);
        map2.put("a", "11");
        map2.put("b", "22");
        map2.put("c", "33");
        datas.add(map2);
        String jsonResult = JSON.toJSONString(datas);
        return jsonResult;
    }

    /**
     * 通过PrintWriter将响应数据写入response，ajax可以接受到这个数据
     *
     * @param response
     * @param data
     */
    private void renderData(HttpServletResponse response, String data) {
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            printWriter.print(data);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (null != printWriter) {
                printWriter.flush();
                printWriter.close();
            }
        }
    }
}


