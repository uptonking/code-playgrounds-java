package yao.step.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoo on 6/17/17.
 */
public class RadixSort {

    public static int[] sortArray(int[] a) {
        sortArray1(a, 10);
        return a;
    }

    /**
     * 不支持0，不支持负数
     * @param a
     * @param radix
     */
    public static void sortArray1(int[] a, int radix) {

        //找到最大数，确定要排序几趟
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

        //建立十个队列
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




    //基数排序的实现有两种方式，低位优先法LSM，适用于位数较小的数排序，高位优先法MSD，适用于位数较多的情况
    //本方法暂不支持0
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




    public static List<Integer> sortList(List<Integer> a) {

        return a;
    }

}
