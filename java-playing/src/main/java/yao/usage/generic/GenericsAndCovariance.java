package yao.usage.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}

/**
 * 泛型协变
 */
public class GenericsAndCovariance {

    public static void main(String[] args) {
        // Wildcards allow covariance:
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // Compile Error: can’t add any type of object:
//         flist.add(new Apple());
//         flist.add(new Fruit());
        // flist.add(new Object());
//        flist.add(null); // Legal but uninteresting
        // We know that it returns at least Fruit:
        Fruit f = flist.get(0);
    }
}


class SuperTypeWildcards {


    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
//         apples.add(new Fruit()); // Error
    }
}

class SuperTypeWildcards2 {

    static void writeTo(List<? extends Apple> apples) {
        ///全部报错
//        apples.add(new Apple());
//        apples.add(new Jonathan());
//        apples.add(new Fruit()); // Error
    }
}

class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist =
                Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0); // No warning
        flist.contains(new Apple()); // Argument is ‘Object’
        flist.indexOf(new Apple()); // Argument is ‘Object’

        //无法编译
//        flist.add(new Apple());

    }
}


class CovariantArrays {

    public static void main(String[] args) {
        ///协变不能添加父类
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple(); // OK
        fruit[1] = new Jonathan(); // OK
        // Runtime type is Apple[], not Fruit[] or Orange[]:
        try {
            // Compiler allows you to add Fruit:
            fruit[0] = new Fruit(); // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            // Compiler allows you to add Oranges:
            fruit[0] = new Orange(); // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
