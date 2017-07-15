package yao.basic.sort.ext;

import java.util.Arrays;

/**
 * 鸡尾酒排序,也就是定向冒泡排序, 鸡尾酒搅拌排序, 搅拌排序 (也可以视作选择排序的一种变形),
 * 涟漪排序, 来回排序 or 快乐小时排序, 是冒泡排序的一种变形。此算法与冒泡排序的不同处在于排序时是以双向在序列中进行排序。
 */
public class CocktailSort {


    /**
     * 鸡尾酒排序
     *
     * @param intArray
     */
    private static void cocktailSort(int[] intArray) {
        int bottom = 0;// 索引开始位置
        int top = intArray.length - 1;// 索引结束位置
        boolean flag = true;// 控制排序停止

        int count = 0;// 记录排序次数
        while (flag) {
            flag = false;
            // 从左到右,升序
            for (int i = bottom; i < top; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                    flag = true;
                }
            }
            top--;
            // 从右到左,降序
            for (int j = top; j > bottom; j--) {
                if (intArray[j] < intArray[j - 1]) {
                    swap(intArray, j, j - 1);
                    flag = true;
                }
            }
            bottom++;

            count++;// 一次比较结束+1
            System.out.println("第" + count + "次排序:" + Arrays.toString(intArray));
        }
    }

    /**
     * 数组元素替换
     *
     * @param intArray 指定的数组
     * @param i        待替换的下标
     * @param j        替换的下标
     */
    private static void swap(int[] intArray, int i, int j) {
        int temp = intArray[i];
        intArray[i] = intArray[j];
        intArray[j] = temp;
    }

    public static void main(String[] args) {
        int[] intArray =
                {
                        10, 3, 5, 7, 1, 9, 6, 2, 4, 8
                };
        cocktailSort(intArray);
        System.out.println("\n排序后:" + Arrays.toString(intArray));
    }

}
