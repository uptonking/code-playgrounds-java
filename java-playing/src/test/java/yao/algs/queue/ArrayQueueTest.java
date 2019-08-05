package yao.algs.queue;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * ArrayQueue Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 12, 2018</pre>
 */
public class ArrayQueueTest {

    ArrayQueue<String> algs = new ArrayQueue<>();

    @Before
    public void before() throws Exception {
        algs.enQueue("aaa");
        algs.enQueue("bbb");
        algs.offer("ccc");
        algs.offer("ddd");

    }

    @After
    public void after() throws Exception {
        algs.clear();
    }

    /**
     * Method: enQueue(E e)
     */
    @Test
    public void testEnQueue() throws Exception {
        algs.enQueue("queue-tail");
        assertEquals("queue-tail", algs.get(algs.size() - 1));
    }

    /**
     * Method: deQueue()
     */
    @Test
    public void testDeQueue() throws Exception {
        String head = algs.deQueue();
        assertEquals("aaa", head);
    }

    /**
     * Method: offer(E e)
     */
    @Test
    public void testOffer() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: poll()
     */
    @Test
    public void testPoll() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: peek()
     */
    @Test
    public void testPeek() throws Exception {
        String head = algs.peek();
        assertEquals("aaa", head);
    }


}
