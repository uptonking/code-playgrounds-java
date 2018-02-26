package yao.algs.graph.dijkstra;

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

        graph = new Graph(5);

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 1, 3);
        graph.addEdge(3, 2, 9);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 0, 7);
        graph.addEdge(4, 2, 6);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: addEdge(Edge edge)
     */
    @Test
    public void testAddEdgeEdge() throws Exception {
//TODO: Test goes here...
    }


    /**
     * Method: dijkstraShortestPath(int start)
     */
    @Test
    public void testDijkstraShortestPath() throws Exception {
        graph.dijkstraShortestPath(0);
        graph.printShortestPath();
    }

    /**
     * Method: printGraph()
     */
    @Test
    public void testPrintGraph() throws Exception {
        graph.printGraph();
    }

    /**
     * Method: addEdge(int v1, int v2, int weight)
     */
    @Test
    public void testAddEdgeForV1V2Weight() throws Exception {
//TODO: Test goes here...
    }


    /**
     * Method: initStartNode(int start)
     */
    @Test
    public void testInitStartNode() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: getMinDsitance(TwoWayList<Integer> u)
     */
    @Test
    public void testGetMinDsitance() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: relaxEdge(Edge edge)
     */
    @Test
    public void testRelaxEdge() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: printShortestPath()
     */
    @Test
    public void testPrintShortestPath() throws Exception {
//TODO: Test goes here...
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
