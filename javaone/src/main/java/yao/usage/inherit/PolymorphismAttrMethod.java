package yao.usage.inherit;

import static java.lang.System.out;

class BaseCLass {

    public int book = 1111;

    public void test() {
        out.println("父类test()打印：" + book);
    }

    public void base() {
        out.println("父类base()执行");
    }

}

class SubCLass extends BaseCLass {

    public String book = "子类book变量";

    public void test() {
        out.println("子类test()打印：" + book);
    }

    public void sub() {
        out.println("子类sub()执行");
    }

}

public class PolymorphismAttrMethod {

    public static void main(String... args) {

        BaseCLass bc = new SubCLass();
        out.println(bc.book);

        bc.test();
        bc.base();

        //bc编译时无sub方法，下行代码报错
        //bc.sub();
    }

}
