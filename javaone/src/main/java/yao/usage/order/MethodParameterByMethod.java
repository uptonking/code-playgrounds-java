package yao.usage.order;

/**
 * 测试方法为lambda表达式时，参数计算顺序
 * <p>
 * ** 结论
 * - 方法a参数是调用方法b得到的，则会先进入b中
 * - 方法a参数是lambda生成的对象时，会先进入方法，执行到lambda对象时，再进行实例化
 * - 注意 修改变量的影响，本例中 product()方法中修改c1会影响到devidedBy2()
 *
 * @author yaoo on 4/5/18
 */
public class MethodParameterByMethod {

    public static int c1 = 4;

    public static void main(String[] args) {

        int x = 1;

        int y = product(x, (Add) (a, b) -> a + b + devidedBy2());

        System.out.println("====c1 计算完成时:" + c1);

        System.out.println("最终计算结果是" + y);

    }

    public static int product(int a, Add aa) {

        c1 = c1 * 2;
        System.out.println("====c1 product内:" + c1);

        a = a * 2;

        return a * aa.add(a, a);
    }

    public static int multipliedBy2(int original) {
        return 2 * original;
    }

    public static int devidedBy2() {
        c1 = c1 / 2;
        System.out.println("====c1 devidedBy2内:" + c1);

        return c1;
    }

}

interface Add {
    int add(int a, int b);
}
