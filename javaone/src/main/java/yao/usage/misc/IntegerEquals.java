package yao.usage.misc;

/**
 * Created by yaoo on 1/26/18
 */
public class IntegerEquals {

    public static void main(String[] args) {

        Integer a = 127;
        int b = 127;
        Integer c = new Integer(127);

        System.out.println(a == b);
        System.out.println(a == c);
    }

}
