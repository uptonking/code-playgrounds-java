package yao.string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * StringSplit Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Feb 27, 2018</pre>
 */
public class StringSplitTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: removeTailByDelimiter(String str, String regex)
     */
    @Test
    public void testRemoveTailByDelimiter() throws Exception {
        System.out.println(StringSplit.removeTailByDelimiter("/a/b/c.d", "/"));
    }


}
