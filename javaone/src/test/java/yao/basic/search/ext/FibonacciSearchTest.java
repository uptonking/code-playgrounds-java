package yao.basic.search.ext;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import yao.algs.search.ext.FibonacciSearch2;

/**
 * FibonacciSearch2 Tester.
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
     * Method: search(int[] number, int des)
     */
    @Test
    public void testSearch() throws Exception {
        int[] aa = {22, 24, 26, 28,42,44,46,48,100, 114, 116, 118,122,124,126};
        int r9 = FibonacciSearch2.search(aa, 116);
        System.out.println(r9);
    }

    /**
     * Method: main(String[] args)
     */
    @Test
    public void testMain() throws Exception {
//TODO: Test goes here...
    }


    /**
     * Method: createFibonacci(int max)
     */
    @Test
    public void testCreateFibonacci() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = FibonacciSearch2.getClass().getMethod("createFibonacci", int.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

    /**
     * Method: findX(int[] fib, int n, int des)
     */
    @Test
    public void testFindX() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = FibonacciSearch2.getClass().getMethod("findX", int[].class, int.class, int.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

}
