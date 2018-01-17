package yao.algs.graph.bellmanford;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Graph Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 17, 2018</pre>
 */
public class GraphTest {
    private Graph graph;

    @Before
    public void before() throws Exception {
        graph = new Graph(5);

        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 3, 7);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, -4);
        graph.addEdge(2, 1, -2);
        graph.addEdge(3, 2, -3);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 0, 2);
        graph.addEdge(4, 2, 7);
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
     * Method: bellmanFordShortestPath(int start)
     */
    @Test
    public void testBellmanFordShortestPath() throws Exception {
        int start = 0;
        boolean spSuccess = graph.bellmanFordShortestPath(start);

        if (spSuccess) {
            System.out.println("起点索引为：" + start);
            graph.printShortestPath();
        } else {
            System.out.println("图中存在负环，到索引为" + start + "顶点的最短路径不存在");
        }
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
     * Method: printShortestPath()
     */
    @Test
    public void testPrintShortestPath() throws Exception {
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
