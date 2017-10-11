package designModel.ProxyModel;

import java.lang.reflect.Proxy;

/**
 * Created by longjinwen on 10/10/2017.
 */
public class UserProxyTest {
    public static void main(String[] args) {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        UserProxy proxy = new UserProxy(userServiceImpl);

        UserService userService =(UserService) Proxy.newProxyInstance(userServiceImpl.getClass().getClassLoader(),userServiceImpl.getClass().getInterfaces(),proxy);
        userService.update();

    }
}
