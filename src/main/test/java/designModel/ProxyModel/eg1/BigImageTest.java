package designModel.ProxyModel.eg1;

/**
 * Created by longjinwen on 11/10/2017.
 */
public class BigImageTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Image image = new ImageProoxy(null);
        System.out.println("Cost time:"+(System.currentTimeMillis()-start));
        //当真正要使用这个对象的方法时,程序才会真正创建被代理的对象
        image.show();
    }
}
