package yao.algs.graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

/**
 * MatrixDG Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 17, 2018</pre>
 */
public class MatrixDGTest {

    private MatrixDG<String> g;

    /**
     * 构建测试图
     * b
     * /  \
     * a —— c —— d
     * |         |
     * e —————————
     */
    @Before
    public void before() throws Exception {
        String[] vexAll = "A,B,C,D,E".split(",");
        int[][] matrix = {
                {0, 1, 1, 0, 1},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0}
        };
        g = new MatrixDG<>(vexAll, matrix);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: addEdge(int i, int j)
     */
    @Test
    public void testAddEdge() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: removeEdge(int i, int j)
     */
    @Test
    public void testRemoveEdge() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: isEdge(int i, int j)
     */
    @Test
    public void testIsEdge() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: getInDegree()
     */
    @Test
    public void testGetInDegree() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: topologicalSort()
     */
    @Test
    public void testTopologicalSort() throws Exception {
        Object[] sorted = g.topologicalSort();
        System.out.println(Arrays.toString(sorted));
    }

    @Test
    public void testTopologicalSortDFS() throws Exception {
        g.topologicalSortDFS();
    }

    /**
     * Method: printGraph()
     */
    @Test
    public void testPrintGraph() throws Exception {
        g.printGraph();
    }

    /**
     * Method: dfs(int i)
     */
    @Test
    public void testDfs() throws Exception {
//        g.dfsRecursive(0);
        System.out.println(Arrays.toString(g.dfs(0)));
    }

    /**
     * Method: bfs(int i)
     */
    @Test
    public void testBfs() throws Exception {
        System.out.println(Arrays.toString(g.bfs(0)));

    }


    /**
     * Method: getPosition(T str)
     */
    @Test
    public void testGetPosition() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = MatrixDG.getClass().getMethod("getPosition", T.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

    /**
     * Method: checkVertexRange(int index)
     */
    @Test
    public void testCheckVertexRange() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = MatrixDG.getClass().getMethod("checkVertexRange", int.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

}
