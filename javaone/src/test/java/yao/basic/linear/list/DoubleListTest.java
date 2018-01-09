package yao.basic.linear.list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * DoubleList Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 25, 2017</pre>
 */
public class DoubleListTest {

    @Before
    public void before() throws Exception {
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
     * Method: addNode(DoubleNode<T> node, int position)
     */
    @Test
    public void testAddNode() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addToTail(T item)
     */
    @Test
    public void testAddToTail() throws Exception {

        DoubleList<Integer> list = new DoubleList<>();

        for (int i = 1; i < 9; i++) {
            list.addToTail(i * 10);
        }

        list.display();

        list.reverse();

        list.display();

    }

    /**
     * Method: addToHead(T item)
     */
    @Test
    public void testAddToHead() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: removeNode(int position)
     */
    @Test
    public void testRemoveNode() throws Exception {
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
     * Method: reverse()
     */
    @Test
    public void testReverse() throws Exception {
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
