package yao.usage.misc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yaoo on 6/16/17.
 * 测试注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface CustomAnno {

//    String color();
    String color() default "red";

    String value();

    int[] arrayAttr() default {1,2,4};
}
