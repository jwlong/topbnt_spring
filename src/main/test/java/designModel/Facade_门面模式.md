# 门面模式
## 概念
> 门面模式被称为正面模式，外观模式，用于将一组复杂的类包装到一个简单的外部接口中

在未使用门面模式时，可能会成这样
![](images/nofacade.png)
使用了门面模式之后会变成这样
![](images/facade.png)

接下来来看代码
以消费者去饭店吃饭为例
消费者要在饭店成功吃到饭，消费者的行为:
haveDinner(),payMoney付钱,类似于客户端
饭店要的事有.提供食物(cook),服务员上菜(waiter)
在未使用门面模式之前会是这样
这样有pay的实现类


不多说，上代码

接口`Payment.java`

```
public interface Payment {
     String pay();
}

```

`Payment.java`实现类`PaymentImpl.java`

```
public class PaymentImpl implements Payment {
    public   String pay(){
        String food = "快餐";
        System.out.println("消费者已经向收银员支付了费用，购买的食物是:"+food);
        return food;
    }
}

```
`Cook.java` 接口

```
public interface Cook {
    String cook(String food);
}

```
`CookImpl.java` 实现类
```
public class CookImpl implements Cook {
  public String cook(String food) {
      System.out.println("厨师正在做食物..."+food);
      return food;
  }
}
```
`Waiter.java` 接口
```
public interface Waiter {
    void serve(String food);
}

```

`WaiterImpl.java`实现类
```
public class WaiterImpl implements Waiter {
    public void serve(String food) {
        System.out.println("食物："+food+" 端上来了...");
    }
}
```
