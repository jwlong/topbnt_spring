package annotationTest;

/**
 * Created by longjinwen on 27/11/2017.
 */
public class NewAnnotationTest {
    @NewAnnotation("test")
    public static void main(String[] args) {
        say();
    }
    @NewAnnotation("sayMethod")
    public static  void say(){

    }
}
