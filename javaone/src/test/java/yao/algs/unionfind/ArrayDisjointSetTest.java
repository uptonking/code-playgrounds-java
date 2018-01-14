package yao.algs.unionfind;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * ArrayDisjointSet Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 14, 2018</pre>
 */
public class ArrayDisjointSetTest {


    private ArrayDisjointSet dSet;

    @Before
    public void before() throws Exception {


        dSet = new ArrayDisjointSet(6);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: union(int root1, int root2)
     */
    @Test
    public void testUnion() throws Exception {
        dSet.unionBySize(1, 2);

        for(int i : dSet.s)
            System.out.print(i + " ");

        dSet.unionBySize(3, 4);

        System.out.println();
        for(int i : dSet.s)
            System.out.print(i + " ");

        System.out.println();
        dSet.unionBySize(1, 3);
        for(int i : dSet.s)
            System.out.print(i + " ");

        System.out.println();
        dSet.unionBySize(1, 0);
        for(int i : dSet.s)
            System.out.print(i + " ");

        System.out.println();
        int x = dSet.find(4);
        System.out.println(x);

        for(int i : dSet.s)
            System.out.print(i + " ");
    }

    /**
     * Method: find(int x)
     */
    @Test
    public void testFind() throws Exception {
//TODO: Test goes here...
    }


}
