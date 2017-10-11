package designModel.ProxyModel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by longjinwen on 10/10/2017.
 * 添加UserProxy代理 对象
 */
public class UserProxy implements InvocationHandler{
    private Object targetObj;
    public UserProxy(Object targetObj){
        this.targetObj = targetObj;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //这个userServiceImp才是需要被代理的对象
        UserServiceImpl userServiceImp = (UserServiceImpl) targetObj;
        return  method.invoke(targetObj,args);
    }
}
