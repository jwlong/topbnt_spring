package common_grammer.interfaceTest;

/**
 * Created by longjinwen on 30/10/2017.
 */
public class ImpT1 implements  T1 {
    public static void main(String[] args) {
        //不能再更变接口定义的成员变量
        System.out.println(s);
    }
}
