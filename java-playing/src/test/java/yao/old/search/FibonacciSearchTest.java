package yao.old.search;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static yao.algs.search.FibonacciSearch.*;

/**
 * FibonacciSearch3 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 21, 2017</pre>
 */
public class FibonacciSearchTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: createFibonacci()
     */
    @Test
    public void testCreateFibonacci() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: search(int[] a, int key)
     */
    @Test
    public void testSearch() throws Exception {
//        int[] f = createFibonacci();

//    int[] data = {1, 5, 15, 22, 25, 31, 39, 42, 47, 49, 59, 68, 88};
        int[] data = {1,2,3};
        int search = 3;
        int position = search(data, search);
        System.out.println("值为" + search + "的元素下标为：" + position);
    }


}
