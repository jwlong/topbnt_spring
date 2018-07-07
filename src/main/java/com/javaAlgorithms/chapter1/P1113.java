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
}
