package com.dxfjyygy.controller;

import com.dxfjyygy.mdl.*;
import com.dxfjyygy.service.MessageService;
import com.dxfjyygy.utils.CheckUtil;
import com.dxfjyygy.utils.Contants;
import com.dxfjyygy.utils.MessageUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/2 0002.
 */
@Controller
public class WinXinController {
    @Autowired
    private MessageService messageService;

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
    //其中produces 设置响应页面给头，兼容中文
    @RequestMapping(value = "/wx.do",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String handler(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //request.setCharacterEncoding("utf-8");
        //response.setContentType("text/xml;charset=utf-8");
        String message = "";
        try {
            Map<String,String> map = MessageUtil.xmlToMap(request);
            String fromUserName = map.get("FromUserName");
            String toUserName = map.get("ToUserName");
            String msgType = map.get("MsgType");
            String content = map.get("Content");
            String msgId = map.get("MsgId");
            String picUrl = map.get("PicUrl");
            String mediaId = map.get("MediaId");
            String eventType = map.get("Event");

            BaseMessage baseMessage = new BaseMessage();
            baseMessage.setFromUserName(toUserName);
            baseMessage.setToUserName(fromUserName);
            baseMessage.setCreateTime(new Date().getTime());
            baseMessage.setFuncFlag(0);
            baseMessage.setMsgId(msgId);
            // 判断 1，2 ，3，4种情况
            System.out.println("Type:"+msgType);
            if(StringUtils.isNotBlank(eventType)){
                if("subscribe".equals(eventType)){
                    message = getWelcomeInfo(baseMessage);
                }
            }else if("1".equals(content)){
                System.out.println("图片消息======>");
                String description = "图片说明1";
                String title = "图文标题";
                picUrl = Contants.LOCAL_TEST_URL+request.getContextPath()+"/static/images/1.jpg";
                //String url = "www.topbnt.com";
                String url = Contants.LOCAL_TEST_URL;
                message = this.buildNewsMessage(baseMessage,description,picUrl,title,url);
                //text.setPicUrl(picUrl);
                //text.setMediaId(mediaId);

            }else if(Contants.RESP_LOCATION_TYPE.equals(msgType)){//location
                String location_x = map.get("Location_X");
                String location_y = map.get("Location_Y");
                String scale = map.get("Scale");
                String label = map.get("Label");
                TextMessage text = new TextMessage();
                text.setToUserName(fromUserName); //此时From User 与 To User的角色会对调
                text.setFromUserName(toUserName);
                text.setCreateTime(new Date().getTime());
                text.setMsgType(Contants.RESP_TEXT_TYPE);
                text.setMsgId((msgId));
                text.setContent("地址："+label+"\n坐标 x:"+location_x+"\n y:"+location_y);
                message = MessageUtil.textMessageToXMl(text);
            }else if(Contants.RESP_IMAGE_TYPE.equals(msgType)){
                System.out.println(picUrl);
                // message = buildImageMessage(fromUserName,toUserName,msgId,picUrl,mediaId);
                if(!"".equals(picUrl)){
                    String description = "上面你发的图片，反弹回你，当然我也收下了";
                    String title = "你发的图片";
                    String url = Contants.LOCAL_TEST_URL+"/images/maimeng.jpg";
                    message  = buildNewsMessage(baseMessage,description,picUrl,title,url);
                }


            } else if("1314".equals(content)){
                // go to show love to
                System.out.println("1314测试一下>");
                String description = "七夕飞起!";
                String title = "couple 来一双";
                String jpg =".jpg";
                picUrl = "http://90bab5e3.ngrok.io/images/1"+jpg;
                String url = "www.topbnt.com/tpl/index.html";
                message = this.buildNewsMessage(baseMessage,description,picUrl,title,url);
            }else{
                TextMessage text = new TextMessage();
                text.setToUserName(fromUserName); //此时From User 与 To User的角色会对调
                text.setFromUserName(toUserName);
                text.setCreateTime(new Date().getTime());
                text.setMsgType(Contants.RESP_TEXT_TYPE);
                text.setMsgId((msgId));
                text.setContent("哈哈，本人比较懒，你输入的内容我不想理啦!暂只支持文字，表情，图片，地理位置,试试1吧\n,对了你刚才输入的是:"+content);
                message = MessageUtil.textMessageToXMl(text);
            }
            //

        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }
    public String buildImageMessage(String fromUserName,String toUserName,String msgId,String picUrl,String mediaId) {
        ImageMessage imageMessage = new ImageMessage();
        //picUrl = "http://90bab5e3.ngrok.io/images/1.jpg";
        imageMessage.setToUserName(fromUserName);
        imageMessage.setFromUserName(toUserName);
        imageMessage.setCreateTime(new Date().getTime());
        imageMessage.setMsgId(msgId);
        imageMessage.setPicUrl(picUrl);
        //imageMessage.setMediaId(mediaId);
        imageMessage.setMsgType(Contants.RESP_IMAGE_TYPE);
        return MessageUtil.imageMessageToXml(imageMessage);
    }

    public String getWelcomeInfo(BaseMessage baseMessage){
        TextMessage textMessage = new TextMessage();
        textMessage.setFromUserName(baseMessage.getFromUserName());
        textMessage.setToUserName(baseMessage.getToUserName());
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setFuncFlag(0);
        textMessage.setMsgId(baseMessage.getMsgId());
        textMessage.setMsgType(Contants.RESP_TEXT_TYPE);
        textMessage.setContent("欢迎关注我的公众号，这个公众号是我展示自己的一个开始\n,无聊时，可以尝试回复文字，" +
                "图片，地理位置\n,会有不同发现,公众号现正在折腾中，可以输入\"1\"试试,功能慢慢在完善\n,最后谢谢关注");
        return MessageUtil.textMessageToXMl(textMessage);
    }

    public String buildNewsMessage(BaseMessage baseMessage,String desc, String picUrl,String title,String url){
        NewsMessage newsMessage = new NewsMessage();
        newsMessage.setFromUserName(baseMessage.getFromUserName());
        newsMessage.setToUserName(baseMessage.getToUserName());
        newsMessage.setMsgId(baseMessage.getMsgId());
        newsMessage.setCreateTime(baseMessage.getCreateTime());
        newsMessage.setFuncFlag(baseMessage.getFuncFlag());
        newsMessage.setMsgType(Contants.RESP_NEWS_TYPE);
        //将向用户推送一条图文信息
        Article article = new Article();
        article.setDescription(desc);
        article.setPicUrl(picUrl);
        article.setTitle(title);
        article.setUrl(url);
        List<Article> list = new ArrayList<Article>();
        list.add(article);
        newsMessage.setArticleCount(list.size());
        newsMessage.setArticles(list);
        return MessageUtil.newsMessageToXML(newsMessage);
    }
}
