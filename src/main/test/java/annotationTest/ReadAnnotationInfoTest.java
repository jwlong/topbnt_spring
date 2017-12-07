package annotationTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by longjinwen on 27/11/2017.
 */
public class ReadAnnotationInfoTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("annotationTest.NewAnnotationTest");
        Annotation[] annotations ;
        Method[] methods = c.getDeclaredMethods();

        for(Method method : methods){
            annotations = method.getDeclaredAnnotations();
            System.out.println(method.getName());
            for(Annotation annotation :annotations){
               // System.out.println(annotation.annotationType().getSimpleName());
                System.out.println("方法名为：" + method.getName() + "其上面的注解为：" + annotation.annotationType().getSimpleName());
                Method[] annMethods = annotation.annotationType().getDeclaredMethods();
                for(Method annMethod:annMethods){
                    System.out.println(annMethod.getName());
                }
            }
        }
    }
}
