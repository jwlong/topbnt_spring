package jsonTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by longjinwen on 18/10/2017.
 *测试JSON的几种情况
 * 引入ailibaba 的开源库
 */
public class JsonTest1 {
    @Test
    public void test1(){
        Map<String,Object> map1 = new LinkedHashMap<String,Object>();
        map1.put("t1", 1);
        map1.put("t3", 3);
        map1.put("t2", 2);
        map1.put("t4", 4);
        //这样就完成了json的有序输出
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.putAll(map1);
        System.out.println(jsonObject);

    }
}
