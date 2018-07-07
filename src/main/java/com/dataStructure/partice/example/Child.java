package com.dataStructure.partice.example;

/**
 * Created by Administrator on 2017/12/6 0006.
 */
public class Child extends  Parent {
    //private  age获取不到
    // protect name 可以取
    public Child(String s1,String s2){
        // 其实这里有一个隐形 的super()
        System.out.println("child contruct!!");
    }
    public void print(){
        System.out.println("B");
    }
    public static void main(String[] args) {
            Parent parent = new Child("","");
            Child child = (Child) parent;
            child.print(); //result: p contruct! child contruct!!
    }
    public void test(){
        System.out.println(name);
    }
}
