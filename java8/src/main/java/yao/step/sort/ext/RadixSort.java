package yao.step.sort.ext;

import java.util.Arrays;

/**
 * 基数排序
 * <pre>
 * 基数排序可以说是扩展了的桶式排序，比如当待排序列在一个很大的范围内，
 * 比如0到999999内，那么用桶式排序是很浪费空间的。而基数排序把每个排序码拆成由d个排序码，
 * 比如任何一个6位数（不满六位前面补0）拆成6个排序码，分别是个位的，十位的，百位的。。。。
 * 排序时，分6次完成，每次按第i个排序码来排。 一般有两种方式:
 * 1) 高位优先(MSD)： 从高位到低位依次对序列排序
 * 2）低位优先(LSD)： 从低位到高位依次对序列排序
 * 计算机一般采用低位优先法（人类一般使用高位优先），但是采用低位优先时要确保排序算法的稳定性。
 * 基数排序借助桶式排序，每次按第N位排序时，采用桶式排序。
 * 对于如何安排每次落入同一个桶中的数据有两种安排方法：
 * 1）顺序存储：每次使用桶式排序，放入r个桶中，，相同时增加计数。
 * 2）链式存储：每个桶通过一个静态队列来跟踪。
 * </pre>
 *
 * @author yuanyan.cao@gmail.com
 */
public class RadixSort {

    public static boolean USE_LINK = true;

    /**
     * @param keys
     * @param from
     * @param len
     * @param radix key's radix
     * @param d     how many sub keys should one key divide to
     */
    public void sort(int[] keys, int from, int len, int radix, int d) {
        if (USE_LINK) {
            link_radix_sort(keys, from, len, radix, d);
        } else {
            array_radix_sort(keys, from, len, radix, d);
        }

    }


    private final void array_radix_sort(int[] keys, int from, int len, int radix,
                                        int d) {
        int[] temporary = new int[len];
        int[] count = new int[radix];
        int R = 1;

        for (int i = 0; i < d; i++) {
            System.arraycopy(keys, from, temporary, 0, len);
            Arrays.fill(count, 0);
            for (int k = 0; k < len; k++) {
                int subkey = (temporary[k] / R) % radix;
                count[subkey]++;
            }
            for (int j = 1; j < radix; j++) {
                count[j] = count[j] + count[j - 1];
            }
            for (int m = len - 1; m >= 0; m--) {
                int subkey = (temporary[m] / R) % radix;
                --count[subkey];
                keys[from + count[subkey]] = temporary[m];
            }
            R *= radix;
        }

    }


    private static class LinkQueue {
        int head = -1;
        int tail = -1;
    }

    private final void link_radix_sort(int[] keys, int from, int len, int radix, int d) {

        int[] nexts = new int[len];

        LinkQueue[] queues = new LinkQueue[radix];
        for (int i = 0; i < radix; i++) {
            queues[i] = new LinkQueue();
        }
        for (int i = 0; i < len - 1; i++) {
            nexts[i] = i + 1;
        }
        nexts[len - 1] = -1;

        int first = 0;
        for (int i = 0; i < d; i++) {
            link_radix_sort_distribute(keys, from, len, radix, i, nexts, queues, first);
            first = link_radix_sort_collect(keys, from, len, radix, i, nexts, queues);
        }
        int[] tmps = new int[len];
        int k = 0;
        while (first != -1) {

            tmps[k++] = keys[from + first];
            first = nexts[first];
        }
        System.arraycopy(tmps, 0, keys, from, len);


    }

    private final void link_radix_sort_distribute(int[] keys, int from, int len,
                                                  int radix, int d, int[] nexts, LinkQueue[] queues, int first) {

        for (int i = 0; i < radix; i++) queues[i].head = queues[i].tail = -1;
        while (first != -1) {
            int val = keys[from + first];
            for (int j = 0; j < d; j++) val /= radix;
            val = val % radix;
            if (queues[val].head == -1) {
                queues[val].head = first;
            } else {
                nexts[queues[val].tail] = first;

            }
            queues[val].tail = first;
            first = nexts[first];
        }

    }

    private int link_radix_sort_collect(int[] keys, int from, int len,
                                        int radix, int d, int[] nexts, LinkQueue[] queues) {
        int first = 0;
        int last = 0;
        int fromQueue = 0;
        for (; (fromQueue < radix - 1) && (queues[fromQueue].head == -1); fromQueue++) ;
        first = queues[fromQueue].head;
        last = queues[fromQueue].tail;

        while (fromQueue < radix - 1 && queues[fromQueue].head != -1) {
            fromQueue += 1;
            for (; (fromQueue < radix - 1) && (queues[fromQueue].head == -1); fromQueue++) ;

            nexts[last] = queues[fromQueue].head;
            last = queues[fromQueue].tail;

        }
        if (last != -1) nexts[last] = -1;
        return first;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 4, 8, 3, 2, 9, 5, 0, 7, 6, 9, 10, 9, 135, 14, 15, 11, 222222222, 1111111111, 12, 17, 45, 16};
        USE_LINK = true;
        RadixSort sorter = new RadixSort();
        sorter.sort(a, 0, a.length, 10, 10);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }
}
