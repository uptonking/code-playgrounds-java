package yao.old.search;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import yao.algs.search.FibonacciSearch;

/**
 * BinarySearch Tester.
 */
public class SearchTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSearchNonRecursively() throws Exception {
//        int[] aa = {16, 6, 14, 5};
//        int[] aa = {2, 4, 6, 8, 12, 14, 16, 18, 22, 24, 26, 28, 32, 34, 36, 38};
//        int[] aa = {22, 24, 26, 28, 32, 34, 36,38,42,44,46,48};
        int[] aa = {22, 24, 26, 28, 32, 34, 36,38};

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

//        int r5 = BlockSearch.searchBlockly(aa, new int[]{8, 18, 28,38}, 34, 4);
//        System.out.println(r5);

//        int r6 = HashSearch.searchHashtable(aa, 5);
//        System.out.println(r6);

//        int r7 =BinarySearchTree.searchBinaryTree(aa,14);
//        System.out.println(r7);

//        int r8 =InsertSearch.searchNonRecursively(aa,14,0,aa.length-1);
//        System.out.println(r8);

        int r9 = FibonacciSearch.search(aa,22);
        System.out.println(r9);
        System.out.println(" ");


    }


}
