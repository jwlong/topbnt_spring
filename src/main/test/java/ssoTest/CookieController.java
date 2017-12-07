package ssoTest;

import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by longjinwen on 27/11/2017.
 */
@Controller
@RequestMapping("/test")
public class CookieController {
    @RequestMapping(name = "/showCookie")
    @ResponseBody
    public String showCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String result = "";
        if(cookies == null){
            result =  "not found cookie info";
        }else{
            for(Cookie c : cookies){
                result += "cookieName:"+c.getName()+" cookieValue:"+c.getValue()+" \n";
            }
        }
        return result;
     }
}
