package yao.usage.inherit;

/**
 * 测试静态方法重写
 * <p>
 * Created by yaoo on 1/26/18
 */
public class TestStaticMethodExtends {

    public static void main(String[] args) {
        A a = new B();

        //输出 父类A
        a.mStatic();

        //输出 子类B
        a.mInstance();
    }
}

class A {
    public static void mStatic() {
        System.out.println("父类A static method");
    }

    public void mInstance() {
        System.out.println("父类A instance method");
    }
}

class B extends A {

    public static void mStatic() {
        System.out.println("子类B static method");
    }

    @Override
    public void mInstance() {
        System.out.println("子类B instance method");
    }

}
