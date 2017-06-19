package yao.step.sort;

import java.util.List;

/**
 * 插入排序
 * 从第2个元素开始，依次选取一个元素两两交换到前面的有序数组
 */
public class InsertSort {

    public static void  sortArray(int[] a){

        int length = a.length;

        for(int i=1;i<length;i++){

            for(int j=i;j>0&&a[j]<a[j-1];j--){
                int temp = a[j];
                a[j]=a[j-1];
                a[j-1]=temp;
            }

        }
    }

    public static void sortList(List<Integer> a){


    }

}
