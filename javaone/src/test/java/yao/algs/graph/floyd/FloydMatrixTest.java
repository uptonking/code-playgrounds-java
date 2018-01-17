package yao.algs.graph.floyd;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * FloydMatrix Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 17, 2018</pre>
 */
public class FloydMatrixTest {

    private FloydMatrix graph;
    private final int MAX = Integer.MAX_VALUE;

    @Before
    public void before() throws Exception {
        int[][] matrix = {
                {0, 3, 8, MAX, -4},
                {MAX, 0, MAX, 1, 7},
                {MAX, 4, 0, MAX, MAX},
                {2, MAX, -5, 0, MAX},
                {MAX, MAX, MAX, 6, 0}
        };
        graph = new FloydMatrix(matrix);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: addEdge(int v, int w, int weight)
     */
    @Test
    public void testAddEdge() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: floydShortestPath()
     */
    @Test
    public void testFloydShortestPath() throws Exception {
        graph.floydShortestPath();
        graph.printShortestPath();
    }


}
