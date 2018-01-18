package yao.old;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

import static yao.usage.misc.IntAbs.*;

/**
 * IntAbs Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 15, 2017</pre>
 */
public class IntAbsTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: calcIntAbs(int intInput)
     */
    @Test
    public void testCalcIntAbs() throws Exception {

        byte b1=127,b2=-128;
        byte bb1 = (byte) -b1;
        //下面一行未报错
        byte bb2 =(byte) -b2;

        int int1 = 0, int2 = 11, int3 = -11, int4 = -2147483648, int5 = 2147483647;
        assertEquals(0,calcIntAbs(int1));
        assertEquals(11,calcIntAbs(int2));
        assertEquals(11,calcIntAbs(int3));
        assertEquals(2147483648L,calcIntAbs(int4));
        assertEquals(2147483647,calcIntAbs(int5));



    }


}
