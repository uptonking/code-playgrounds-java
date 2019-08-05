package yao.collectionx;

import java.util.ArrayList;
import java.util.List;

/**
 * foreach 语法糖
 * <p>
 * Created by yaoo on 3/12/18
 */
public class ForEachIteration {

    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        ///编译器会转换成 Iterator迭代器
        //        Iterator var2 = list.iterator();
        //        while(var2.hasNext()) {
        //            String s = (String)var2.next();
        //            System.out.println(s);
        //        }
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();


        String[] arr = {"s1", "s2"};
        ///编译器回转换成 普通的fori循环
        //      for(int i = 0; i < length; ++i) {
        //      String s = arr[i];
        //      System.out.println(s);
        //        }
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println();


        int[] arrInt = {11, 22, 33};
        for (int ii : arrInt) {
            System.out.println(ii);

        }
        System.out.println();

        for (Integer jj : arrInt) {
            System.out.println(jj);
        }
        System.out.println();

    }

}
