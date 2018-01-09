package yao.usage.misc;

/**
 * Created by yaoo on 6/16/17.
 */
@CustomAnno("随便设个值")
public class CustomAnnoClass {
    public static void main(String[] args){

        //用反射测试CustomAnnoClass上是否有注解
        if (CustomAnnoClass.class.isAnnotationPresent(CustomAnno.class)){
            CustomAnno anno = CustomAnnoClass.class.getAnnotation(CustomAnno.class);

//            System.out.println(anno);
            System.out.println(anno.color());
            System.out.println(anno.value());

        }

    }
}
