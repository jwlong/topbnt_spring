package designModel.FacadeModel.common;

/**
 * Created by longjinwen on 27/10/2017.
 */
public class CookImpl implements Cook {
    public String cook(String food) {
        System.out.println("厨师正在做食物..."+food);
        return food;
    }
}
