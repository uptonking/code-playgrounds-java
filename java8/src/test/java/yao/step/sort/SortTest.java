package yao.step.sort;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

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
        int[] aa = {7,5,3,1, 8,6,4,10,2,0,-8,-1,-4,-100,-10,200,-50,30};
//        int[] aa = {9, 1, 6, 4, 2, 1, 0, 6};
//        int[] aa = {16,6,14,4,12,2};
//        System.out.println(Arrays.toString(SelectSort.sortArray(aa)));
//        System.out.println(Arrays.toString(InsertSort.sortArray(aa)));
//        System.out.println(Arrays.toString(ShellSort.sortArray(aa)));
//        System.out.println(Arrays.toString(ShellSort.sortArray2(aa)));
//        System.out.println(Arrays.toString(ShellSort.sortArray3(aa)));
//        System.out.println(Arrays.toString(MergeSort.sortArray(aa)));
//        System.out.println(Arrays.toString(QuickSort.sortArray(aa)));
//        System.out.println(Arrays.toString(HeapSort.sortArray(aa)));
//        System.out.println(Arrays.toString(BubbleSort.sortArray(aa)));
//        System.out.println(Arrays.toString(RadixSort.sortLSD(aa)));
//        System.out.println(Arrays.toString(RadixSort.sortArray(aa)));
        BucketSort.sortArray(aa);
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
