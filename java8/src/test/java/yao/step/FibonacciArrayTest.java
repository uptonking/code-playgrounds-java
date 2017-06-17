package yao.step;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;
import static yao.step.FibonacciArray.calcFibonacciNonRecursive;
import static yao.step.FibonacciArray.calcFibonacciRecursive;

/**
 * FibonacciArray Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 16, 2017</pre>
 */
public class FibonacciArrayTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: calcFibonacciRecursive(int intInput)
     */
    @Test
    public void testCalcFibonacciRecursive() throws Exception {

        assertEquals(1, calcFibonacciRecursive(1));
        assertEquals(13, calcFibonacciRecursive(7));

        long startTime = System.currentTimeMillis();

        int nFibo = calcFibonacciRecursive(25);

        long endTime = System.currentTimeMillis();

        System.out.println(new DecimalFormat(",###").format(nFibo));
//        System.out.println(new DecimalFormat(",###").format(calcFibonacciRecursive(25)));

        System.out.printf("递归版本计算的时间是：%.5f s  %n ", (endTime - startTime) / 1000.0);

    }

    /**
     * Method: calcFibonacciNonRecursive(int intInput)
     */
    @Test
    public void testCalcFibonacciNonRecursive() throws Exception {
        assertEquals(1, calcFibonacciNonRecursive(1));
        assertEquals(55, calcFibonacciNonRecursive(10));

//    System.out.println(new DecimalFormat(",###").format(calcFibonacciNonRecursive(35)));
        long startTime = System.currentTimeMillis();
//    System.out.println(String.valueOf(startTime));

        int nFibo = calcFibonacciNonRecursive(25);
//    System.out.println(String.valueOf(nFibo));

        long endTime = System.currentTimeMillis();
//    System.out.println(String.valueOf(endTime));
        System.out.println(new DecimalFormat(",###").format(nFibo));


        System.out.printf("非递归版本计算的时间是：%.5f  s  %n ", (endTime - startTime) / 1000.0);
//    System.out.println(String.valueOf(endTime-startTime));


    }


} 
