package yao.old.nonlinear.heap;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

/**
 * MaxHeap Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 29, 2017</pre>
 */
public class MaxHeapTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: heapify(T[] a, int i, int heapLength)
     */
    @Test
    public void testHeapify() throws Exception {
        Integer[] aa = {1, 8, 5, 7, 9, 3, 0, 4, 2, 6};
        MaxHeap<Integer> maxHeap = new MaxHeap();
        maxHeap.buildHeap(aa, aa.length);
        String outA = Arrays.toString(aa);
        System.out.println(outA);

    }


}
