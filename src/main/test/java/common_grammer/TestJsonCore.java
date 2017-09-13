package common_grammer;

import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by longjinwen on 2017/4/20.
 * 主要是来测试并跟踪JSON类的源码
 */
public class TestJsonCore {
    /**
     * 测添加map
     */
    @Test
    public void test1(){
        Map<String ,Object> map =  new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject(map);
        System.out.println(jsonObject.toString());
    }
    @Test
    public void test2(){
        Map<String ,Object> map =  new HashMap<String, Object>();
        map.put("1",1);
        map.put("2",2);
        JSONObject jsonObject = new JSONObject(map);
        String s = jsonObject.toString();
        System.out.println(s);

    }

    /**
     * 查看Map 源码 怎么把数据装进去的。
     */
    @Test
    public void test3(){
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put(1,1);
    }

    /**
     * map hashMap
     */
    @Test
    public void test4(){
        Map map = new HashMap();
        map.put(null,null); // 允许插入空值
        System.out.println(map.size());
    }
    @Test
    public  void test5(){
        Map map = new Hashtable();
        map.put(null,null); // 这个应该要报空指针异常
         //虽然Hashtable是线程安全的，但是呢，在有同步问题的情况下，也不推荐用hashtable, 推荐使用Collections.synchronizeMap(hashMap);
    }
}
