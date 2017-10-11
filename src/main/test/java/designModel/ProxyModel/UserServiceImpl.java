package designModel.ProxyModel;

/**
 * Created by longjinwen on 10/10/2017.
 */
public class UserServiceImpl implements  UserService {
    public void update() {
        System.out.println(" user update...");
    }

    public void add() {
        System.out.println("user add");
    }

    public void delete(User user) {
        System.out.println("user delete");
    }
}
