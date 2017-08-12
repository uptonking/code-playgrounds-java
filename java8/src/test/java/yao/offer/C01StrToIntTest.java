package yao.offer;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

import static yao.offer.C01StrToInt.convertStrToInt;

/**
 * Q00StrToInt Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Aug 11, 2017</pre>
 */
public class C01StrToIntTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: convertStrToInt(String strInput)
     */
    @Test
    public void testConvertStrToInt() throws Exception {

        assertEquals(convertStrToInt("123"), 123);
        assertEquals(convertStrToInt("-123"), -123);
        assertEquals(convertStrToInt("+123"), 123);
        assertEquals(convertStrToInt("2147483647"), 2147483647);
        assertEquals(convertStrToInt("-2147483648"), -2147483648);

//        System.out.println(convertStrToInt("123a34"));
//        System.out.println(convertStrToInt("2147483648"));
//        System.out.println(convertStrToInt("-2147483649"));
//        System.out.println(convertStrToInt("-21474836409"));
//        convertStrToInt(null);
//        convertStrToInt("");

    }


} 
