package yao.basic.linear.stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * LinkedListStack Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 27, 2017</pre>
 */
public class LinkedListStackTest {

    LinkedListStack listStack;

    @Before
    public void before() throws Exception {
        listStack = new LinkedListStack(3);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: isEmpty()
     */
    @Test
    public void testIsEmpty() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: size()
     */
    @Test
    public void testSize() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: traverse()
     */
    @Test
    public void testTraverse() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: search(T item)
     */
    @Test
    public void testSearch() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: push(T item)
     */
    @Test
    public void testPush() throws Exception {

        listStack.display();

        listStack.push(4);
        listStack.push(4);
        listStack.push(4);
        listStack.push(5);
        listStack.display();

        listStack.pop();
        listStack.display();

    }

    /**
     * Method: pop()
     */
    @Test
    public void testPop() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: peek()
     */
    @Test
    public void testPeek() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: clear()
     */
    @Test
    public void testClear() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: display()
     */
    @Test
    public void testDisplay() throws Exception {
//TODO: Test goes here... 
    }


} 
