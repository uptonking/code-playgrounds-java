package yao.algs.search.ext;

//import QuickSort;

import java.util.Arrays;

public class FibonacciSearch2 {

    /**
     * 斐波那契查找，数组长度可变，createFibonacci(arr.length);
     * 不能查找数组中的最大值
     * 未创建辅助数组
     *
     * @param arr
     * @param des
     * @return
     */
    public static int search(int[] arr, int des) {

        int[] fib = createFibonacci(arr.length);
        System.out.println(Arrays.toString(fib));

        //斐波那契数组下标
        int x = findX(fib, arr.length + 1);

        int m = arr.length - fib[x];
        x--;

        //输入数组下标
        int i = x;
        if (arr[i] < des)
            i += m;

        while (fib[x] > 0) {
            if (arr[i] < des)
                i += fib[--x];
            else if (arr[i] > des)
                i -= fib[--x];
            else
                return i;
        }
        return -1;
    }

    //建立费氏数列
    private static int[] createFibonacci(int max) {
        int[] fib = new int[max];
        for (int i = 0; i < fib.length; i++) {
            fib[i] = Integer.MIN_VALUE;
        }
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < max; i++)
            fib[i] = fib[i - 1] + fib[i - 2];
        return fib;
    }

    //找y值
    private static int findX(int[] fib, int n) {
        int i = 0;
        while (fib[i] <= n)
            i++;
        i--;
        return i;
    }

//    public static void main(String[] args) {
//
//        int[] number = {1, 4, 2, 6, 7, 3, 9, 8};
//        QuickSort.sortArray(number);
//
//        int find = FibonacciSearch2.search(number, 3);
//
//        if (find != -1)
//            System.out.println("找到数字的索引为" + find);
//        else
//            System.out.println("找不到数字");
//    }


}
