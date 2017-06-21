package yao.key;

/**
 * Created by yaoo on 6/15/17.
 */
public class StrConstantPool {

    public static void main(String[] args) {

        String s1 = new StringBuilder("漠").append("然").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("漠").append("然").toString();
        System.out.println(s2.intern() == s2);

        String s3 = new StringBuilder("漠3").append("然").toString();
        System.out.println(s3.intern() == s3);

    }

}
