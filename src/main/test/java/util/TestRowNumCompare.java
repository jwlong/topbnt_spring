package util;

import com.dxfjyygy.mdl.SkuLine;

import java.util.Comparator;

/**
 * Created by longjinwen on 14/08/2017.
 */
public class TestRowNumCompare implements Comparator<SkuLine> {
    private static TestRowNumCompare instance = new TestRowNumCompare();
    public static TestRowNumCompare getInstance(){
        return instance;
    }
    @Override
    public int compare(SkuLine o1, SkuLine o2) {
        return new Integer(o1.getRownum()).compareTo(new Integer(o2.getRownum()));
    }
}
