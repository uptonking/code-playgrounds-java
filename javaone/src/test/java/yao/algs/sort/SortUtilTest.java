package yao.algs.sort;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * SortUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 18, 2018</pre>
 */
public class SortUtilTest {

    private SortUtil sortUtil;
    private Integer[] arr;
    private String expected;

    @Before
    public void before() throws Exception {
        sortUtil = new SortUtil();

    }

    @After
    public void after() throws Exception {
    }


    /**
     * Method: selectSort(Comparable[] a)
     */
    @Test
    public void testSelectSort() throws Exception {
        arr = new Integer[]{57, 68, 59, 62};
        expected = "[57, 59, 62, 68]";
        Object[] result = sortUtil.selectSort(arr);

        assertEquals(expected, Arrays.toString(result));
        System.out.println(Arrays.toString(result));
    }

    /**
     * Method: heapSort(Comparable[] a)
     */
    @Test
    public void testHeapSort() throws Exception {
        arr = new Integer[]{61, 31, 41, 21, 91, 81, 71, 51};
        expected = "[21, 31, 41, 51, 61, 71, 81, 91]";
        Object[] result = sortUtil.heapSort(arr);

        assertEquals(expected, Arrays.toString(result));
        System.out.println(Arrays.toString(result));
    }

    /**
     * Method: insertSort(Comparable[] a)
     */
    @Test
    public void testInsertSort() throws Exception {
        arr = new Integer[]{61, 31, 41, 21, 91, 81, 71, 51};
        expected = "[21, 31, 41, 51, 61, 71, 81, 91]";
        Object[] result = sortUtil.insertSort(arr);

        assertEquals(expected, Arrays.toString(result));
        System.out.println(Arrays.toString(result));
    }

    /**
     * Method: shellSort(Comparable[] a)
     */
    @Test
    public void testShellSort() throws Exception {
        arr = new Integer[]{61, 31, 41, 21, 91, 81, 71, 51};
        expected = "[21, 31, 41, 51, 61, 71, 81, 91]";
        Object[] result = sortUtil.shellSort(arr);

        assertEquals(expected, Arrays.toString(result));
        System.out.println(Arrays.toString(result));
    }

    /**
     * Method: bubbleSort(Comparable[] a)
     */
    @Test
    public void testBubbleSort() throws Exception {
        arr = new Integer[]{61, 31, 41, 21, 91, 81, 71, 51};
        expected = "[21, 31, 41, 51, 61, 71, 81, 91]";
        Object[] result = sortUtil.bubbleSort(arr);

        assertEquals(expected, Arrays.toString(result));
        System.out.println(Arrays.toString(result));
    }

    /**
     * Method: quickSort(Comparable[] a)
     */
    @Test
    public void testQuickSort() throws Exception {
        //arr = new Integer[]{61, 31, 41, 21, 91, 81, 71, 51};
        arr = new Integer[]{4,4,4,4,4,4,4,4};
        expected = "[21, 31, 41, 51, 61, 71, 81, 91]";
        Object[] result = sortUtil.quickSortRecursive(arr);
//        Object[] result = sortUtil.quickSortStack(arr);

        //assertEquals(expected, Arrays.toString(result));
        System.out.println(Arrays.toString(result));
    }

    /**
     * Method: mergeSort(Comparable[] a)
     */
    @Test
    public void testMergeSort() throws Exception {
        arr = new Integer[]{61, 31, 41, 21, 91, 81, 71, 51};
        expected = "[21, 31, 41, 51, 61, 71, 81, 91]";
//        Object[] result = sortUtil.mergeSortRecursive(arr);
        Object[] result = sortUtil.mergeSortIterative(arr);

        assertEquals(expected, Arrays.toString(result));
        System.out.println(Arrays.toString(result));
    }

    /**
     * Method: radixSort(Comparable[] a)
     */
    @Test
    public void testRadixSort() throws Exception {
        arr = new Integer[]{61, 31, 41, 211, 91, 811, 71, 51};
        expected = "[31, 41, 51, 61, 71, 91, 211, 811]";
        Object[] result = sortUtil.radixSortLSD(arr);

        assertEquals(expected, Arrays.toString(result));
        System.out.println(Arrays.toString(result));
    }


}
