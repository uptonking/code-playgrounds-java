package yao.algs.graph.prim;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Graph Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 16, 2018</pre>
 */
public class GraphTest {

    private Graph graph;

    @Before
    public void before() throws Exception {
        graph = new Graph(9);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 5, 4);
        graph.addEdge(2, 8, 2);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: addEdge(Edge edge)
     */
    @Test
    public void testAddEdge() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: removeEdge(Edge edge)
     */
    @Test
    public void testRemoveEdge() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: primMST()
     */
    @Test
    public void testPrimMST() throws Exception {
        Integer minWeightSum = graph.primMST();
        System.out.println(minWeightSum);
    }

    /**
     * Method: getMinEdge(TwoWayList<Integer> t)
     */
    @Test
    public void testGetMinEdge() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: print()
     */
    @Test
    public void testPrint() throws Exception {
        graph.print();
    }

    /**
     * Method: equals(Object obj)
     */
    @Test
    public void testEquals() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
//TODO: Test goes here...
    }


}
