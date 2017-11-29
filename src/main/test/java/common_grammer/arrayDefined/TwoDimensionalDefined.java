package common_grammer.arrayDefined;

/**
 * Created by longjinwen on 30/10/2017.
 */
public class TwoDimensionalDefined {
    public static void main(String[] args) {
        int [] i[] = new int[2][2];
        int a [] = {1,2};
        long  b = 0;
        byte  c = 0;
        short s = 0;
        char  ch = 0;

        System.out.println(a[ch]);
        //System.out.println(a[b]); // 数组的下标能用int,byte,short,char 但不能用long
        int a1 = 0;
        long l = a1;
        //自动转
    }
}
