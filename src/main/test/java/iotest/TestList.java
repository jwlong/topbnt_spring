package iotest;

import com.dxfjyygy.mdl.SkuLine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by longjinwen on 14/08/2017.
 */
public class TestList {
    public static void main(String[] args) {
            List<SkuLine> skuLines = buidlList();
            List<SkuLine> skuLinesCopy = new ArrayList<SkuLine>(skuLines);
            for(SkuLine skuLine: skuLines){
                System.out.println(skuLine.getRownum());
            }
            Collections.sort(skuLines, TestRowNumCompare.getInstance());
            System.out.println(" After copy");
            for(SkuLine oldSku :skuLinesCopy){
                System.out.println(oldSku.getRownum());
            }
    }
    public static  List<SkuLine> buidlList(){
        List<SkuLine> list = new ArrayList<SkuLine>();
        SkuLine skuLine3 = new SkuLine();
        skuLine3.setRownum(3);
        skuLine3.setName("name3");
        skuLine3.setValue("value3");
        SkuLine skuLine = new SkuLine();
        skuLine.setRownum(1);
        skuLine.setName("name1");
        skuLine.setValue("value1");

        SkuLine skuLine2 = new SkuLine();
        skuLine2.setRownum(2);
        skuLine2.setName("name2");
        skuLine2.setValue("value2");
        list.add(skuLine);
        list.add(skuLine3);
        list.add(skuLine2);
        return list;
    }
}
