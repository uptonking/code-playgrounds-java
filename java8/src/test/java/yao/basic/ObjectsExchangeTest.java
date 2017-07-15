package yao.basic;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;


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
        ObjectsExchange.swapInt1(2, 3);
        ObjectsExchange.swapInt2(2, 3);
        ObjectsExchange.swapInt3(2, 3);
        ObjectsExchange.swapInt4(2, 3);
    }


} 
