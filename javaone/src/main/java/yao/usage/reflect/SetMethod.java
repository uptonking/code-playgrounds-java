package yao.usage.reflect;

import yao.usage.bean.BeanAllStr;

import java.lang.reflect.Field;

/**
 * @author yaoo on 4/8/18
 */
public class SetMethod {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

//        Class clazz = BeanAllStr.class;
        Class clazz = Class.forName("yao.usage.bean.BeanFieldAllType");

        Field f = clazz.getDeclaredField("int1");

        System.out.println(f.getType().getName());


    }

}
