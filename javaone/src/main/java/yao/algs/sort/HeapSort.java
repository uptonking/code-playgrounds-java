package yao.algs.sort;

import java.util.List;

/**
 * 堆排序
 * 先构建大顶堆，再交换堆顶和末位
 */
public class HeapSort {

    public static void sortArray(int[] a) {

        int length = a.length;

        for (int i = 0; i < length - 1; i++) {
            //构造大顶堆
            buildMaxHeap(a, length - 1 - i);

            //交换堆顶和数组末位元素
            int temp = a[0];
            a[0] = a[length - 1 - i];
            a[length - 1 - i] = temp;

        }
    }

    private static void buildMaxHeap(int[] arr, int lastIndex) {

        //从lastIndex处节点即最后一个节点的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {

            //k保存正在判断的节点，循环到父节点都比字节点大
            for (int k = i; 2 * k + 1 <= lastIndex; ) {

                //k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;

                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    //若果右子节点的值较大
                    if (arr[biggerIndex] < arr[biggerIndex + 1]) {
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }

                //如果k节点的值小于其较大的子节点的值
                if (arr[k] < arr[biggerIndex]) {
                    //交换他们
                    int temp = arr[k];
                    arr[k] = arr[biggerIndex];
                    arr[biggerIndex] = temp;

                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }


            }
        }
    }


    //对arr数组从0到lastIndex建大顶堆，while循环
    private static void buildMaxHeap2(int[] arr, int lastIndex) {

        //从lastIndex处节点即最后一个节点的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {

            //k保存正在判断的节点
            int k = i;

            //如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {

                //k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;

                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    //若果右子节点的值较大
                    if (arr[biggerIndex] < arr[biggerIndex + 1]) {
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }

                //如果k节点的值小于其较大的子节点的值
                if (arr[k] < arr[biggerIndex]) {
                    //交换他们
                    int temp = arr[k];
                    arr[k] = arr[biggerIndex];
                    arr[biggerIndex] = temp;

                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }



    public static List<Integer> sortList(List<Integer> a) {


        return a;
    }

}
