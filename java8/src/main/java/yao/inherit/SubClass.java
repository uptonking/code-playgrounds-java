package yao.inherit;

/**
 * Created by yaoo on 4/28/17.
 */
public class SubClass extends SuperClass {

    private int number;


    public SubClass(int number) {
        super(number);
    }


    public int getNumber() {
        number++;
        return number;
    }


    public static void main(String[] args) {

        SuperClass s = new SubClass(10);
        SuperClass s1 = new SubClass1(20);
        SuperClass s2 = new SubClass2(30);

        System.out.println(s.getNumber()); //1
//        System.out.println(s1.getNumber()); //21
//        System.out.println(s2.getNumber()); //31

        //结论一：多态时，当子类覆盖了父类的方法，使用子类覆盖的方法
        //结论二：当子类覆盖父类的成员变量时，父类方法使用的是父类的成员变量，子类方法使用的是子类的成员变量
    }
}
