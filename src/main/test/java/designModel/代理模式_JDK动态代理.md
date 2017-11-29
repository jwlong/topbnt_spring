
# 代理模式
## 概念
>当客户端代码不能或者不想直接 访问被调用的对象，而额外
创建一个代理对象返回给客户端使用，那么这种设计方式为代理模式。

### 演示一个小例子
- 最有需要实现的接口 Image.java

```
public interface Image {
    void show();
}


```
- 模拟一张大图片 BigImage.java

```
*/
public class BigImage implements Image {
   public void show() {
       try {
           //模拟装载时间
           Thread.sleep(3000);
           System.out.println("Big Image Load Success!");
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
}


```

- 代理类 ImageProoxy.java

```
public class ImageProoxy implements Image {
    private Image image;
    public ImageProoxy(Image image){
        this.image = image;
    }

    public void show() {
        if(image == null){
            image = new BigImage();
        }
        image.show();
    }
}

```

- 最后看看测试类

```
public class BigImageTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Image image = new ImageProoxy(null);
        System.out.println("Cost time:"+(System.currentTimeMillis()-start));
        //当真正要使用这个对象的方法时,程序才会真正创建被代理的对象,这样明显感觉到花销减少
        image.show();
    }
}


```

### 下面来看一个JDK动态代理的例子

- 开始定义一个接口

```
public interface UserService{
   public void update();
   public void add();
   public void delete(User user);
}

```
- 接口实现类

```
public class UserServiceImpl implements UserService{
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

```
- 代理类

```
public class UserProxy implements InvocationHandler{
  private Object target;
  //添加一个构造方法，传入实际需要被代理的对象
  public UserProxy(Object target){
      this.target = target;
  }
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //这个userServiceImp才是需要被代理的对象
        UserServiceImpl userServiceImp = (UserServiceImpl) targetObj;
        return  method.invoke(targetObj,args);
  }
}

```
- 测试类

```
public class UserProxyTest{
  public static void main(String[] args){
    UserServiceImpl userServiceImp = new UserServiceImpl();
    UserProxy userProxy = new UserProxy(userServiceImp);

    UserService UserService = (UserService)Proxy.newProxyInstance(userServiceImp.getClass().getClassLoader(),uuserServiceImp.getClass().getInterfaces(),userProxy);

    UserService.update(); // 此时会打印 user update...
  }
}

```
