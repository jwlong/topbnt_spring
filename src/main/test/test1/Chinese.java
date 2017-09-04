package com.dxfjyygy.test.test1;

/**
 * Created by longjinwen on 2017/2/28.
 */
public class Chinese implements Person {
    public Chinese() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Axe getAxe() {
        return axe;
    }

    private String name;
    public Chinese(String name){
        this.name = name;
    }
    private  Axe axe;
    //只需要使用set 方法
    public void setAxe(Axe axe) {
        this.axe = axe;
    }

    public void useAxe() {
        System.out.println(axe.chop());
    }
}

