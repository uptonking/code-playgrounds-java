package yao.algs.graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

/**
 * LinkedGraph Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 15, 2018</pre>
 */
public class LinkedGraphTest {

    private LinkedGraph<String> g;
    private String[] arr = "A,B,C,D,E,F,G,H,I".split(",");

    @Before
    public void before() throws Exception {
        g = new LinkedGraph<>(arr, false);
        int[][] edgeKV = {
                {0, 1}, {0, 5}, {1, 2}, {1, 8}, {1, 6},
                {2, 3}, {2, 8}, {3, 4}, {3, 6}, {3, 7}, {3, 8},
                {4, 5}, {4, 7}, {6, 5}, {6, 7}
        };

        for (int i = 0; i < edgeKV.length; i++) {
            g.addEdge(edgeKV[i][0], edgeKV[i][1]);
        }
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: addEdge(int v, int w)
     */
    @Test
    public void testAddEdge() throws Exception {
        g.print();
    }

    /**
     * Method: bfs(int v)
     */
    @Test
    public void testBfs() throws Exception {
        System.out.println(Arrays.toString(g.bfs(0)));
    }

    /**
     * Method: dfs(int v)
     */
    @Test
    public void testDfs() throws Exception {
        System.out.println(Arrays.toString(g.dfs(0)));
    }

    @Test
    public void testDfsRecursive() throws Exception {
        g.dfsRecursive(0);
    }

    /**
     * Method: hasEdge(int v, int w)
     */
    @Test
    public void testHasEdge() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: degree(int i)
     */
    @Test
    public void testDegree() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: getAdj(int i)
     */
    @Test
    public void testGetAdj() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: toArray()
     */
    @Test
    public void testToArray() throws Exception {
//TODO: Test goes here...
    }


    /**
     * Method: addVertex(Vertex<T> vex)
     */
    @Test
    public void testAddVertexVex() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: addVertex(T data)
     */
    @Test
    public void testAddVertexData() throws Exception {
//TODO: Test goes here...
    }


    /**
     * Method: checkVertexRange(int index)
     */
    @Test
    public void testCheckVertexRange() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = LinkedGraph.getClass().getMethod("checkVertexRange", int.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

}
