package yao.usage.init;

/**
 * 实例变量的声明赋值会被构造函数赋值覆盖
 * <p>
 * 子类分配内存及初始化之前初始化分类
 * <p>
 * 实例方法可以多态，但实例变量没有多态，java里面没有字段的重写
 */
public class Base {

    private String baseName = "base";

    //构造方法
    public Base() {
        callName();
    }

    //对象方法
    public void callName() {
        System.out.println("====Base callName: " + baseName);
    }


    /**
     * 程序的入口
     * <p>
     * 输出：
     * ====Sub callName: null
     * ====Sub callName: sub2
     */
    public static void main(String[] args) {

        //这里会调用子类的callName()，因为有重写，但是子类变量未分配内存
        Base b = new Sub();

        //调用子类
        b.callName();

    }

    //静态内部类
    static class Sub extends Base {

        //静态内部类的字段
        private String baseName = "sub";

        public Sub() {
            baseName = "sub2";
        }

        //静态类中的方法，可以发现，是对父类中方法的重写
        public void callName() {
            System.out.println("====Sub callName: " + baseName);
        }
    }

}
