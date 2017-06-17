package yao.keys;

import java.util.Arrays;

/**
 * Created by yaoo on 6/16/17.
 */
public class ArrayHelper {


    public static void printIntArray() {
        int[] intArray = {6, 2, 3, 4, 5};
        boolean[] booleanArray=new boolean[8];
        String intArrayString = Arrays.toString(intArray);
// 直接打印,则会打印出引用对象的Hash值
// [I@7150bd4d
        System.out.println(intArray);
        System.out.println(intArray.getClass().getName());
// [1, 2, 3, 4, 5]

        System.out.println(booleanArray);
        System.out.println(booleanArray.getClass().getName());

        System.out.println(intArrayString);
    }
}
