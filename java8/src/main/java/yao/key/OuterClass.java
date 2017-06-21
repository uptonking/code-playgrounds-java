package yao.key;

/**
 * Created by yaoo on 6/20/17.
 */
public class OuterClass {

    public OuterClass() {
        System.out.println("outer class 构造函数");

    }

    public class InnerClass {
        public InnerClass() {
            System.out.println("outer class 构造函数");

        }

    }

}
