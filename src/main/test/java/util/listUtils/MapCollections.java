package util.listUtils;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by longjinwen on 18/08/2017.
 */
public class MapCollections {
    //测试  Map  --LinkedHashMap
    @Test
    public  void test1(){
        Map<String,Object> map = new LinkedHashMap<String, Object>();
        map.put("1",1);
        map.put("2",2);
        map.put("4",7);
        map.put("3",3);
        print(map);

    }
    public void print(Map map){
        for(Object o :map.entrySet()){
            System.out.println(o);
           // System.out.println(map.get(o));
        }
    }

    public void print2(Map map){
        for(Object o :map.values()){
            System.out.println(o);
        }
    }

    public void print3(Map map){
        for(Object o :map.values()){
            System.out.println(o);
        }
    }
    @Test
    public void test2(){
        Map <String,Object> hashMap = new HashMap<String, Object>();
        hashMap.put("1",1);
        hashMap.put("2",2);
        hashMap.put("4",7);
        hashMap.put("3",3);
        print(hashMap);
    }
    // TreeMap
    @Test
    public void test3(){
        Map<String,Object> treeMap = new TreeMap<String, Object>();
        System.out.println("tree Map test");
        treeMap.put("str3",3);// key 必须要实现 comparable 接口 (至少 String,Integer,Long,Short,Byte,Float,Double)
        treeMap.put("str1",1);
        treeMap.put("str2",2);
        print(treeMap);
    }

    @Test
    public void test4(){

    }
}
