package com.dxfjyygy.util;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by longjinwen on 2017/4/20.
 */
public class JSON {
    private  static  final JSON instance = new JSON();
    public static String toJSONString(List<Map<String,Object>>  list){
        Map<String ,Object>  targetMap = new HashMap<String, Object>();
     //   targetMap.put("1",list);
        JSONObject jsonObj = new JSONObject(targetMap);
//        for(Map<String,Object> map:list){
//            JSONObject jsonObj = new JSONObject(map);
//        }

        return jsonObj.toString();
    }

    public static void main(String[] args) {
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for(int i=0;i<3;i++){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("1",i);
            map.put("2",i+1);
            list.add(map);
        }
        System.out.println(toJSONString(list));
    }
}
