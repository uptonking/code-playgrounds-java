package yao.algs.stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * LinkedStack Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 12, 2018</pre>
 */
public class LinkedStackTest {

    private LinkedStack<String> algs = new LinkedStack<>();

    @Before
    public void before() throws Exception {
        algs.push("aaa");
        algs.push("bbb");
        algs.push("ccc");
        algs.push("ddd");
    }

    @After
    public void after() throws Exception {
        algs.clear();
    }

    /**
     * Method: push(E e)
     */
    @Test
    public void testPush() throws Exception {
        algs.push("phsh-here");
        System.out.println(Arrays.toString(algs.toArray(new String[algs.size()])));
    }

    /**
     * Method: pop()
     */
    @Test
    public void testPop() throws Exception {
        String top = algs.pop();
        assertEquals("ddd", top);
    }

    /**
     * Method: peek()
     */
    @Test
    public void testPeek() throws Exception {
        String top = algs.peek();
        assertEquals("ddd", top);
    }

    /**
     * Method: search(Object o)
     */
    @Test
    public void testSearch() throws Exception {
//TODO: Test goes here...
    }


}
