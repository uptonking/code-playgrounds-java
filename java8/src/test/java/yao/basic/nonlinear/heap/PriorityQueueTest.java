package yao.basic.nonlinear.heap;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * PriorityQueue Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 29, 2017</pre>
 */
class Patient implements Comparable {
    private String name;
    private int priority;

    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String toString() {
        return name + "(priority:" + priority + ")";
    }

    @Override
    public int compareTo(Object oo) {//比较优先级
        return this.priority - ((Patient) oo).priority;
    }

}

public class PriorityQueueTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: enqueue(E e)
     */
    @Test
    public void testEnqueue() throws Exception {
        Patient p1 = new Patient("John", 2);
        Patient p2 = new Patient("Tom", 9);
        Patient p3 = new Patient("Jack", 4);
        Patient p4 = new Patient("Michael", 6);

        PriorityQueue<Patient> priorityQueue = new PriorityQueue<>();
        priorityQueue.enqueue(p1);
        priorityQueue.enqueue(p2);
        priorityQueue.enqueue(p3);
        priorityQueue.enqueue(p4);

        while (priorityQueue.getSize() > 0) {
            System.out.print(priorityQueue.dequeue() + "  ");
        }
    }

    /**
     * Method: dequeue()
     */
    @Test
    public void testDequeue() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getSize()
     */
    @Test
    public void testGetSize() throws Exception {
//TODO: Test goes here... 
    }


} 
