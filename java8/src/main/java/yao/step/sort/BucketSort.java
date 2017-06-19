package yao.step.sort;

/**
 * 桶排序
 * 设计桶数量，元素入桶，计算排名，再从后往前排序
 */
public class BucketSort {

    /**
     * 可以处理负数和0
     * 桶的数量可以自己设定，这里默认为整数
     *
     * @param a
     */
    public static void sortArray(int[] a) {

        //计算数组中的min和max，用于建桶
        int min = a[0], max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }
        //System.out.println("预处理信息：" + "min：" + min + " " + "max：" + max);

        //开始建桶，桶的数量等于max - min + 1
        int bucketCount = max - min + 1;
        int[] bucket = new int[bucketCount];
        //System.out.println("桶个数：" + bucketCount + ",桶下标范围0~" + (bucketCount - 1));

        //桶的元素是个数
        for (int i = 0; i < a.length; i++) {
            bucket[a[i] - min]++;
        }
        //System.out.println(Arrays.toString(bucket));

        //计算该桶元素较小数的数量
        for (int i = 1; i < bucketCount; i++) {
            bucket[i] = bucket[i] + bucket[i - 1];
        }
        //System.out.println(Arrays.toString(bucket));

        //创建辅助数组
        int[] copy = new int[a.length];
        System.arraycopy(a, 0, copy, 0, a.length);

        //从后往前排序，保持元素相对位置，保证算法稳定性。  
        for (int i = a.length - 1; i >= 0; i--) {
            a[--bucket[copy[i] - min]] = copy[i];
        }


        //若从前往后排序，虽然排序结果相同，但会破坏元素相对位置和算法稳定性  
//      for(int i = 0; i <= a.length - 1; i++){  
//          a[--bucket[copy[i] - min]] = copy[i];  
//      }  
//        System.out.println("排序后数组：" + Arrays.toString(a));

    }

}
