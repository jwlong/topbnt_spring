package com.javaAlgorithms.chapter1;

/**
 * Created by Administrator on 2018/7/7 0007.
 */
public class P1113 {

    /**
     * M N 二维数组
     * 转换为N M 二维数组
     * @param a
     */

    public static void main(String[] args) {
      //  System.out.println(Math.log(1))
        int result = lg(8);
        System.out.println(result);
    }
    public void reverse(int a[][]){
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[i].length;j++){
                if (i!=j){
                    int tmp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = tmp;

                }
            }
        }
    }
    // 10
    public static int lg(int n){
        int result = 0;
        int m = 0;
         int tmp=1;
            for (int i=1;i<=n;i++){
                tmp *=2;
                if (tmp == n) return i;
                if (tmp > n) return (i-1);

        }

//        while (m<n){
//            m++;
//        }
        return  0;
       // Math.log(1);
    }
}
