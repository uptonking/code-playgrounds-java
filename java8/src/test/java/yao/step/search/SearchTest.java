package yao.step.search;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * BinarySearch Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 19, 2017</pre>
 */
public class SearchTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * 查找算法测试
     */
    @Test
    public void testSearchNonRecursively() throws Exception {
//        int[] aa = {16, 6, 14, 4, 12, 2, 18, 8, 19, 9};
        int[] aa = {2, 4, 6, 8, 12, 14, 16, 18, 22, 24, 26, 28, 32, 34, 36, 38};

//        int r1 = SequentialSearch.searchSequentially(aa, 8);
//        System.out.println(r1);
//
//        int r2 = SequentialSearch.searchSequentially2(aa, 8);
//        System.out.println(r2);
//
//        int r3 = BinarySearch.searchRecursively(aa, 8, 0, aa.length - 1);
//        System.out.println(r3);
//
//        int r4 = BinarySearch.searchNonRecursively(aa, 8, 0, aa.length - 1);
//        System.out.println(r4);

        int r5 = BlockSearch.searchBlockly(aa, new int[]{8, 18, 28,38}, 34, 4);
        System.out.println(r5);


    }


} 
