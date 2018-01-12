package yao.basic.sort;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import yao.algs.sort.RadixSort;

import java.util.Arrays;


/**
 * SelectSort Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 18, 2017</pre>
 */
public class SortTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: sortArray(int[] a)
     */
    @Test
    public void testSortArray() throws Exception {
//        int[] aa = {7,5,3,1, 8,6,4,10,2,0,-8,-1,-4,-100,-10,200,-50,30};
        int[] aa = {9, 1, 6, 4, 2, 1, 6, 100, 20, 0};
//        int[] aa = {16, 6, 14, 4, 12, 2};
//        SelectSort.sortArray(aa);
//        InsertSort.sortArray(aa);
//        ShellSort.sortArray(aa);
//        ShellSort.sortArray2(aa);
//        ShellSort.sortArray3(aa);
//        MergeSort.sortArray(aa);
//        QuickSort.sortArray(aa);
//        HeapSort.sortArray(aa);
//        BubbleSort.sortArray(aa);
//        RadixSort.sortLSD(aa);
//        RadixSort.sortArray(aa);
//        RadixSort.sortArray(aa);
        RadixSort.sortArray(aa);
//        CountingSort.sortArray(aa);
//        CountingSort.sortArray2(aa);

        System.out.println(Arrays.toString(aa));
    }

    /**
     * Method: sortList(List<Integer> a)
     */
    @Test
    public void testSortList() throws Exception {
//TODO: Test goes here...
    }


}
