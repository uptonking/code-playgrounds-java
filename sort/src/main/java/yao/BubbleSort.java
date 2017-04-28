package yao;

/**
 * Created by yaoo on 4/28/17.
 */
public class BubbleSort {

    void  sort(int a[], int m)
    {
        int i,j;
        int tmp;
        int flag = 0;  //设定标志，如果第一次循环比较时没有发生交换，则说明数组是升序排序，不用排序，提前结束循环。
        for(i = 0; i < m; i++)  //外层循环控制循环次数
        {
            for(j = 0; j < m-1-i; j++)    //内层循环控制每次循环里比较的次数。
            {
                if(a[j] > a[j+1])
                {
                    tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = 1;
                }
            }

            if(0 == flag)
            {
                System.out.println("No Sort\n");
                break;
            }
        }
    }


}
