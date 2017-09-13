package common_grammer;

import org.json.JSONObject;
import org.junit.Test;

/**
 * Created by longjinwen on 2017/4/18.
 */
public class testJSONObject {

    @Test
    public void test1(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("1","1");
        jsonObject.accumulate("2","1");
        jsonObject.accumulate("2",3);
        System.out.println(jsonObject.length());
        System.out.println(jsonObject.get("2"));
        System.out.println(jsonObject.toString());
    }
}
