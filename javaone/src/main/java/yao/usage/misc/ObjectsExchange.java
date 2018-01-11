package yao.usage.misc;

/**
 * 交换两个数
 */
public class ObjectsExchange {

    /**
     * 使用临时变量
     *
     * @param a
     * @param b
     */
    public static void swapInt1(int a, int b) {

        int temp;
        temp = a;
        a = b;
        b = temp;

        System.out.print(a+"  ");
        System.out.println(b);

    }

    /**
     * 使用异或
     *
     * @param a
     * @param b
     */
    public static void swapInt2(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.print(a+"  ");
        System.out.println(b);

    }

    /**
     * 加法
     *
     * @param a
     * @param b
     */
    public static void swapInt3(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.print(a+"  ");
        System.out.println(b);

    }

    /**
     * 乘法
     *
     * @param a
     * @param b
     */
    public static void swapInt4(int a, int b) {
        a = a *b;
        b = a / b;
        a = a / b;

        System.out.print(a+"  ");
        System.out.println(b);

    }


}
