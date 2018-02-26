package yao.algs.stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * ArrayStack Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 11, 2018</pre>
 */
public class ArrayStackTest {

    private ArrayStack<String> algs = new ArrayStack<>();

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
        algs.push("push-here");
        System.out.println(Arrays.toString(algs.toArray(new String[algs.size()])));
    }

    /**
     * Method: pop()
     */
    @Test
    public void testPop() throws Exception {
        String old = algs.pop();
        assertEquals("ddd", old);
    }

    /**
     * Method: peek()
     */
    @Test
    public void testPeek() throws Exception {
        String old = algs.peek();
        assertEquals("ddd", old);
    }

    /**
     * Method: search(Object o)
     */
    @Test
    public void testSearch() throws Exception {
//TODO: Test goes here...
    }


}
