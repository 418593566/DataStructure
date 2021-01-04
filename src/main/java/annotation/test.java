package annotation;

import java.lang.annotation.Annotation;

@MyAnnotation(value = "dsf")
public class test {
    public static void main(String[] args) {
        Annotation[] tion =
                test.class.getAnnotations();
        for (int i = 0; i < tion.length; i++) {
            System.out.println(tion[i]);
        }
    }
}
