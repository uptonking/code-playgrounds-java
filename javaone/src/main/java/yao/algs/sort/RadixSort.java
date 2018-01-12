package yao.algs.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基数排序
 * 先根据基数确定桶数量，再元素入桶，再计算排名，再从后往前排序
 */
public class RadixSort {

    /**
     * 支持0和正整数
     * @param a
     */
    public static void sortArray(int[] a) {

        //找到最大数
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        // 用来计算每轮排序的位数值，分别取10，00……
        int exp;

        // 从个位开始，对数组a按位数进行排序
        for (exp = 1; max / exp > 0; exp *= 10) {

            //======================桶排序======================
            //用来存储0-9出现的次数
            int[] bucket = new int[10];

            // 将数据出现的次数存储在bucket[]中
            for (int i = 0; i < a.length; i++) {
                bucket[(a[i] / exp) % 10]++;
            }

            // 更改buckets[i]，目的是让更改后的buckets[i]的值，是该数据在copy[]中的位置。
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }

            // 存储"被排序数据"的临时数组
            int[] copy = new int[a.length];
            System.arraycopy(a, 0, copy, 0, a.length);
            for (int i = a.length - 1; i >= 0; i--) {
                a[--(bucket[(copy[i] / exp) % 10])] = copy[i];
            }

            copy = null;
            bucket = null;
        }
    }


//    public static void sortArray(int[] a) {
//        sortArray(a, 10);
//    }

    /**
     * array    代表数组
     * radix    代表基数
     */
    public static void sortArray(int[] a, int radix) {

        //找到最大数
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        //判断位数
        int d = 0;
        while (max > 0) {
            max = max / 10;
            d++;
        }

        // 临时数组
        int[] tempArray = new int[a.length];
        // count用于记录待排序元素的信息,用来表示该位是i的数的个数
        int[] count = new int[radix];
        //计算下一位
        int rate = 1;

        for (int i = 0; i < d; i++) {

            //重置count数组，开始统计下一个关键字
            Arrays.fill(count, 0);
            //将array中的元素完全复制到tempArray数组中
            System.arraycopy(a, 0, tempArray, 0, a.length);

            //计算每个待排序数据的子关键字
            for (int j = 0; j < a.length; j++) {
                int subKey = (tempArray[j] / rate) % radix;
                count[subKey]++;
            }
            //统计count数组的前j位（包含j）共有多少个数
            for (int j = 1; j < radix; j++) {
                count[j] = count[j] + count[j - 1];
            }
            //按子关键字对指定的数据进行排序 ，因为开始是从前往后放，现在从后忘前读取，保证基数排序的稳定性
            for (int m = a.length - 1; m >= 0; m--) {
                int subKey = (tempArray[m] / rate) % radix;
                a[--count[subKey]] = tempArray[m]; //插入到第--count[subKey]位，因为数组下标从0开始
            }
            rate *= radix;//前进一位
        }

    }

    //基数排序的实现有两种方式，低位优先法LSM，适用于位数较小的数排序，高位优先法MSD，适用于位数较多的情况
    //本方法暂不支持0，支持负数
    public static int[] sortLSD(int a[]) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        int len = 0; // 存贮最大的数的位数，用来判断需要进行几轮基数排序
        while (max > 0) {
            max = max / 10;
            len++;
        }

        for (int times = 0; times < len; times++) // 按位数运行几次，每次都分裂成10份，在顺序链接
        {
            // 以下内容应为每次运行时，分割成0-9 个桶，然后顺序链接
            @SuppressWarnings("unchecked")
            ArrayList<Integer> num[] = new ArrayList[10];
            for (int i = 0; i < num.length; i++) {
                num[i] = new ArrayList<Integer>();
            }

            int k = 1; // 用来取出当前的对应的位数的数
            for (int i = 0; i < times; i++) {
                k = k * 10;
            }

            for (int i = 0; i < a.length; i++) // 对每一个数进行判断位数
            {
                int x = 0; // 用来表示当前的位数上的数的大小
                x = Math.abs(a[i]) / k; // 使用绝对值，防止受到正负号的影响
                x = x % 10;
                num[x].add(new Integer(a[i]));
            }
            // 将排序的结果顺序连接起来
            int count = 0;
            for (int i = 0; i < num.length; i++) {
                for (int j = 0; j < num[i].size(); j++) {
                    a[count++] = num[i].get(j).intValue();
                }
            }
        }

        // 判断完绝对值大小顺序后，需要判断正负了
        ArrayList<Integer> plus = new ArrayList<Integer>(); // 储存正数
        ArrayList<Integer> minus = new ArrayList<Integer>(); // 储存负数
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= 0) {
                minus.add(new Integer(a[i]));
            } else {
                plus.add(new Integer(a[i]));
            }
        }
        int count = 0;
        for (int i = minus.size() - 1; i > 0; i--) // 因为这是按照绝对值大小排列的，所以要倒序
        {
            a[count++] = minus.get(i);
        }
        for (int i = 0; i < plus.size(); i++) {
            a[count++] = plus.get(i);
        }

        return a;
    }


    /**
     * 不支持0，不支持负数
     *
     * @param a
     * @param radix
     */
    public static void sortArray1(int[] a, int radix) {

        //找到最大数
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        //判断位数
        int times = 0;
        while (max > 0) {
            max = max / 10;
            times++;
        }

        //建立10个桶
        List<ArrayList> queue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList queue1 = new ArrayList();
            queue.add(queue1);
        }

        //进行times次分配和收集
        for (int i = 0; i < times; i++) {

            //分配
            for (int j = 0; j < a.length; j++) {
                int x = a[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList queue2 = queue.get(x);
                queue2.add(a[j]);
                queue.set(x, queue2);
            }

            //收集
            int count = 0;
            for (int j = 0; j < 10; j++) {
                while (queue.get(j).size() > 0) {
                    ArrayList<Integer> queue3 = queue.get(j);
                    a[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }

        }
    }


    public static void sortList(List<Integer> a) {

    }

}
