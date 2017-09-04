package com.dxfjyygy.controller;

import com.dxfjyygy.utils.CheckUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/9/2 0002.
 */
@Controller
public class WinXinController {

    @RequestMapping(value = "/wx.do",method = RequestMethod.GET)
    @ResponseBody
    public String  validater(HttpServletRequest request, HttpServletResponse response) {
        // 接收微信服务器以Get请求发送的4个参数
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        if(CheckUtil.checkSignature(signature,timestamp,nonce)){
//            AccessToken token = WenXinUtil.getAccessToken(Contants.APPID,Contants.APPSECRET);
//            if(token != null){
//                Menu menu = MenuManager.getMenu();
//                int result =  WenXinUtil.createMenu(menu,token.getToken());
//                if(result == 0){
//                    log("菜单创成功!");
//                }
//            }
           // out.print(echostr);
            return  echostr;
        }
        return  "";
    }

}
