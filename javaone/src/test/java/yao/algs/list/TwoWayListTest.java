package yao.algs.list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

/**
 * TwoWayList Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 11, 2018</pre>
 */
public class TwoWayListTest {
    private TwoWayList<String> algs;

    @Before
    public void before() throws Exception {
        algs = new TwoWayList<>("array");

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: add(E e)
     */
    @Test
    public void testAddE() throws Exception {
        algs.add("list");
        algs.add("stack");
        algs.add("queue");
        algs.add("tree");
        algs.add("graph");

        algs.remove("graph");
        algs.remove(0);
        algs.removeLast();

        System.out.println(Arrays.toString(algs.toArray(new String[algs.size()])));
    }

    /**
     * Method: add(int index, E e)
     */
    @Test
    public void testAddForIndexE() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: addFirst(E e)
     */
    @Test
    public void testAddFirst() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: addLast(E e)
     */
    @Test
    public void testAddLast() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: remove(Object o)
     */
    @Test
    public void testRemoveO() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: remove(int index)
     */
    @Test
    public void testRemoveIndex() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: removeFirst()
     */
    @Test
    public void testRemoveFirst() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: removeLast()
     */
    @Test
    public void testRemoveLast() throws Exception {
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
     * Method: size()
     */
    @Test
    public void testSize() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: isEmpty()
     */
    @Test
    public void testIsEmpty() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: contains(Object o)
     */
    @Test
    public void testContains() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: toArray(T[] t)
     */
    @Test
    public void testToArray() throws Exception {
//TODO: Test goes here...
    }


    /**
     * Method: checkRange(int index)
     */
    @Test
    public void testCheckRange() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = TwoWayList.getClass().getMethod("checkRange", int.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

}
