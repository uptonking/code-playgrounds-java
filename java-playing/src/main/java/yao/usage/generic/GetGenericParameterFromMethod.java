package yao.usage.generic;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试获得方法参数中的泛型
 *
 * @author jinyaoo
 */
public class GetGenericParameterFromMethod {

    public static void chill(final List<?> aListWithSomeType) {

        // Here I'd like to get the Class-Object 'SpiderMan'
        System.out.println(aListWithSomeType.getClass().getGenericSuperclass());

        System.out.println(
                ((ParameterizedType) aListWithSomeType.getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0]
        );
    }

    public static void main(String... args) {

        // 这里输出 java.util.AbstractList<E>, E
        chill(new ArrayList<SpiderMan>());

        // 这里输出 java.util.ArrayList<yao.usage.generic.SpiderMan>, class yao.usage.generic.SpiderMan
        chill(new ArrayList<SpiderMan>() {
        });

    }


}

class SpiderMan {
}

