package yao.offer;

/**
 * Created by yaoo on 6/16/17.
 * 斐波那契数列相关
 */
public class FibonacciArray {


    /**
     * 计算斐波那契数列的第n个值 非递归
     */
    public static int calcFibonacciNonRecursive(int intInput) {
        int n = intInput;
        int toReturnN = 0;

        if (n <= 2) {
            toReturnN = 1;
        }

        if (n > 2) {

            for (int i = 3, last2 = 1, last3 = 1; i < n + 1; i++) {

                toReturnN = last2 + last3;
                last3 = last2;
                last2 = toReturnN;

            }
        }

        return toReturnN;
    }


    /**
     * 计算斐波那契数列的第n个值 递归
     *
     * @param intInput
     * @return
     */
    public static int calcFibonacciRecursive(int intInput) {
        int n = intInput;
        int toReturnN = 0;

        if (n <= 2) {
            toReturnN = 1;
        }
        if (n > 2) {
            toReturnN = calcFibonacciRecursive(n - 1) + calcFibonacciRecursive(n - 2);
        }

        return toReturnN;

    }

}
