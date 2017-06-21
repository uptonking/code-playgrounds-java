package yao.basic;

/**
 * Created by yaoo on 6/15/17.
 * 计算整数绝对值
 */
public class IntAbs {

    public static long calcIntAbs(int intInput) {

        long input = (long) intInput;
        long toReturnInt;

        toReturnInt = input >= 0 ? input : (-input);

        return toReturnInt;
    }


}
