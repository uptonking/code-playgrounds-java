package yao.algs.heap;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * MinBinaryHeap Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 13, 2018</pre>
 */
public class MinBinaryHeapTest {

    private Integer a[] = {80, 40, 30, 60, 90, 70, 10, 50, 20};
    private MinBinaryHeap<Integer> heap;

    @Before
    public void before() throws Exception {
        heap = new MinBinaryHeap<>(a);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: add(E e)
     */
    @Test
    public void testAdd() throws Exception {
        heap.add(15);
        String newHeap = "[10, 15, 30, 50, 20, 70, 40, 80, 60, 90]";
        assertEquals(newHeap, heap.toString());
    }

    /**
     * Method: remove()
     */
    @Test
    public void testRemove() throws Exception {
        heap.add(15);
        heap.remove();
        String newHeap = "[15, 20, 30, 50, 90, 70, 40, 80, 60]";
        assertEquals(newHeap, heap.toString());
    }

    /**
     * Method: heapify()
     */
    @Test
    public void testHeapify() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
//        System.out.println(heap.toString());
        String minHeap = "[10, 20, 30, 50, 90, 70, 40, 80, 60]";
        assertEquals(minHeap, heap.toString());
    }


    /**
     * Method: buildHeap()
     */
    @Test
    public void testBuildHeap() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = MinBinaryHeap.getClass().getMethod("buildHeap");
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

    /**
     * Method: percolateUp(int cur)
     */
    @Test
    public void testPercolateUp() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = MinBinaryHeap.getClass().getMethod("percolateUp", int.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

    /**
     * Method: percolateDown(int cur)
     */
    @Test
    public void testPercolateDown() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = MinBinaryHeap.getClass().getMethod("percolateDown", int.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

    /**
     * Method: getParent(int i)
     */
    @Test
    public void testGetParent() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = MinBinaryHeap.getClass().getMethod("getParent", int.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

    /**
     * Method: getLeft(int i)
     */
    @Test
    public void testGetLeft() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = MinBinaryHeap.getClass().getMethod("getLeft", int.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

    /**
     * Method: getRight(int i)
     */
    @Test
    public void testGetRight() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = MinBinaryHeap.getClass().getMethod("getRight", int.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

    /**
     * Method: grow()
     */
    @Test
    public void testGrow() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = MinBinaryHeap.getClass().getMethod("grow");
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

}
