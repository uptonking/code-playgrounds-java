package yao.step;

/**
 * Created by yaoo on 6/16/17.
 * 计算斐波那契数列的第n个值
 */
public class FibonacciArray {

    public static int calcFibonacciRecursive(int intInput) {
        int n = intInput;
        int toReturnN = 0;

        if (n < 3) {
            toReturnN = 1;
        }
        if (n >= 3) {
            toReturnN = calcFibonacciRecursive(n - 1) + calcFibonacciRecursive(n - 2);
        }

        return toReturnN;

    }

    public static int calcFibonacciNonRecursive(int intInput) {
        int n = intInput;
        int toReturnN = 0;

        if (n < 3) {
            toReturnN = 1;
        }

        if (n >= 3) {

            for (int i = 3, last2 = 1, last3 = 1; i < n+1; i++) {

                toReturnN = last2 + last3;
                last3 = last2;
                last2 = toReturnN;

            }
        }

        return toReturnN;
    }


}
