package yao.basic;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static yao.basic.ObjectsExchange.swapInt;

/**
 * ObjectsExchange Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 18, 2017</pre>
 */
public class ObjectsExchangeTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: swapInt(int a, int b)
     */
    @Test
    public void testSwapInt() throws Exception {
        swapInt(2, 3);
    }


} 
