package collectiontest;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/11/12 0012.
 */

/**
 * Set 的特性
 * 1.是不允许重复
 * 2. 能够插入null呢
 * 3 存放的元素没有顺序
 */
public class SetTest {
    public static void main(String[] args) {

    }

    /**
     * 测试能不能重复
     */
    @Test
    public void test1(){
        Set<String> strSet = new HashSet<String>();
        strSet.add("21");
        strSet.add("23");
        strSet.add("24");
        System.out.println(strSet.size());

        Set<String> strSet2 = new HashSet<String>();
        String s = "21";
        strSet2.add(s);
        strSet2.add(s);
        strSet2.add("24");
        System.out.println(strSet2.size());

    }


    /**
     * 测试存放的元素有没有 顺序
     * 证明没有顺序看其实现类
     */
    @Test
    public void test2(){
        Set<String> strSet = new HashSet<String>();
        strSet.add("21");
        strSet.add("23");
        strSet.add("24");
        System.out.println(strSet.size());
        for(String s: strSet){
            System.out.println(s);
        }
//        Set<String> strSet2 = new HashSet<String>();
//        strSet2.add("21");
//        strSet2.add("21");
//        strSet2.add("24");
//        System.out.println(strSet.size());

    }


    /**
     * 测试能不能放null
     * 结论：可以放null
     *
     */
    @Test
    public void test3(){
        Set<String> strSet = new HashSet<String>();
        strSet.add("21");
        strSet.add("23");
        strSet.add("24");
        strSet.add(null);
        strSet.add("null");
        System.out.println(strSet.size());
        for(String s: strSet){
            System.out.println(s);
        }
;

    }
}
