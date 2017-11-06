package common_grammer;

import org.junit.Test;

/**
 * Created by longjinwen on 18/10/2017.
 */
public class StringByteCharBoolean {
    /**
     * 测试 Boolean
     */
    @Test
    public void test1(){
        //看看哪个可以的构造参数传String
        Boolean b = new Boolean("true"); //可行,点进去看到 Boolean 实现了Serializable接口
        System.out.println(b);//结果就是true;
        Boolean b1 = new Boolean("true1");   //并且 只有传true时才返回boolean 型结果true
        System.out.println(b1);//结果就是true;
        //  public Boolean(String s) {
//                this(parseBoolean(s));
//            }
//        public static boolean parseBoolean(String s) {
//            return ((s != null) && s.equalsIgnoreCase("true"));
//        }
    }

    /**
     * 测试了Byte
     */
    @Test
    public void test2(){
        Byte testbytes = new Byte("-128"); //也可以看到 Byte 实现了Serializable接口
        //其值的范围为-128~127
        System.out.println(testbytes);
    }
    @Test
    public void test3(){
        Integer i = new Integer("1");
    }
    @Test
    public void test4(){
       // Character c = new Character("sdf"); // 这就要报错了
    }


}
