package yao.step.sort;

import java.util.List;

/**
 * Created by yaoo on 6/17/17.
 */
public class InsertSort {

    public static int[]  sortArray(int[] a){

        int length = a.length;

        for(int i=1;i<length;i++){

            for(int j=i;j>0&&a[j]<a[j-1];j--){
                int temp = a[j];
                a[j]=a[j-1];
                a[j-1]=temp;
            }

        }
        return a;
    }

    public static List<Integer> sortList(List<Integer> a){


        return a;
    }

}
