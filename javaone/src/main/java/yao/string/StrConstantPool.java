package yao.string;

/**
 * Created by yaoo on 6/15/17.
 */
public class StrConstantPool {

//    public static void main(String[] args) {
//
//        String s1 = new StringBuilder("漠").append("然").toString();
//        System.out.println(s1.intern() == s1);
//
//        String s2 = new StringBuilder("漠").append("然").toString();
//        System.out.println(s2.intern() == s2);
//
//        String s3 = new StringBuilder("漠3").append("然").toString();
//        System.out.println(s3.intern() == s3);
//
//
////        String s3 = new StringBuilder("ja").append("va").toString();
////        System.out.println(s3.intern() == s3);
//
//
//    }


    public static void main(String[] args) throws Exception {
        String a =  "b" ;
        String b =  "b" ;

        System.out.println( a == b);

        String c = "d" ;
        String d = new String( "d" ) ;
        System.out.println( c == d.intern());
        System.out.println( d == d.intern());

        //============
        String s1 = "ab123" ;
        String s2 = new String( "ab123" ) ;
        System.out.println( s1 == s2 );
        String s3 = s2.intern() ;
        System.out.println( s1 == s3 ) ;
    }

}
