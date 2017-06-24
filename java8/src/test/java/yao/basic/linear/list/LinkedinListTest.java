package yao.basic.linear.list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * LinkedinList Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 23, 2017</pre>
 */
public class LinkedinListTest {

    LinkedinList<Integer> list;

    @Before
    public void before() throws Exception {
        list = new LinkedinList<>();
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
     * Method: addNode(SingleNode<T> item, int position)
     */
    @Test
    public void testAddNode() throws Exception {

        for (int i = 11; i < 13; i++) {
            list.addNode(new SingleNode<Integer>(i * 10), i%10);

        }

        list.display();

        list.reverse();

        list.display();

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


} 
