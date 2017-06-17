package yao.inherit;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * Base Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 15, 2017</pre>
 */
public class BaseTest {

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testNewChildInstance() throws Exception {
        BaseChild child = new BaseChild();
        assertEquals("yao.inherit.BaseChild", child.toString().split("@")[0]);
    }


}
