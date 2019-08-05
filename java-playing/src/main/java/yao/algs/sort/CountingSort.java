package yao.algs.sort;

/**
 * 计数排序
 * 设计从从0到N个桶，元素入桶，再计算排名，再从后往前排序
 */
public class CountingSort {

    /**
     *需要三个数组:
     *待排序数组 int[] arr = new int[]{4,3,6,3,5,1};
     *辅助计数数组 int[] help = new int[max - min + 1];
     *输出数组 int[] res = new int[arr.length];
     *1.求出待排序数组的最大值max=6， 最小值min=1
     *2.实例化辅助计数数组help，help数组中每个下标对应arr中的一个元素，help用来记录每个元素出现的次数
     *3.计算arr中每个元素在help中的位置 position = arr[i] - min，此时 help = [1,0,2,1,1,1]; （3出现了两次，2未出现）
     *4.根据help数组求得排序后的数组，此时 res = [1,3,3,4,5,6]
     * @param a
     * @return
     */
    public static void sortArray(int[] a){

        if (a == null || a.length == 0) {
            return ;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //找出数组中的最大最小值
        for(int i = 0; i < a.length; i++){
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }
        int help[] = new int[max];
        //找出每个数字出现的次数
        for(int i = 0; i < a.length; i++){
            int mapPos = a[i] - min;
            help[mapPos]++;
        }
        int index = 0;
        for(int i = 0; i < help.length; i++){
            while(help[i]-- > 0){
                a[index++] = i+min;
            }
        }
    }


    /**
     *1.求出待排序数组的最大值max=6， 最小值min=1
     *2.实例化辅助计数数组help，help用来记录每个元素之前出现的元素个数
     *3.计算arr每个数字应该在排序后数组中应该处于的位置，此时 help = [1,1,4,5,6,7];
     *4.根据help数组求得排序后的数组，此时 res = [1,3,3,4,5,6]
     * @param a
     */
    public static void sortArray2(int[] a) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //找出数组中的最大最小值
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }

        int[] help = new int[max - min + 1];
        //找出每个数字出现的次数
        for (int i = 0; i < a.length; i++) {
            int count = a[i] - min;
            help[count]++;
        }

        //计算每个数字应该在排序后数组中应该处于的位置
        for (int i = 1; i < help.length; i++) {
            help[i] = help[i - 1] + help[i];
        }

        //根据help数组进行排序
        int[] copy = new int[a.length];
        System.arraycopy(a, 0, copy, 0, a.length);
        for (int i = a.length - 1; i >= 0; i--) {
            a[--help[copy[i] - min]] = copy[i];
        }

    }

}
