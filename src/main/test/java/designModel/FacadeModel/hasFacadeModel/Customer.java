package designModel.FacadeModel.hasFacadeModel;

/**
 * Created by longjinwen on 27/10/2017.
 */
public class Customer {
    public void haveDinner(){
       //这样就相当清晰简单了,利于扩展
        Facade facade = new Facade();
        facade.serverFood();
    }
}
