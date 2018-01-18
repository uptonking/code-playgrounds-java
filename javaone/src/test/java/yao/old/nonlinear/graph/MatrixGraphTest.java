package yao.old.nonlinear.graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * MatrixGraph Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 29, 2017</pre>
 */
public class MatrixGraphTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getIndex(T t)
     */
    @Test
    public void testGetIndex() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: display()
     */
    @Test
    public void testDisplay() throws Exception {
        String[] vexs = {"A", "B", "C", "D", "E", "F", "G"};
        String[][] edges = new String[][]{
                {"A", "B"},
                {"B", "C"},
                {"B", "E"},
                {"B", "F"},
                {"C", "E"},
                {"D", "C"},
                {"E", "B"},
                {"E", "D"},
                {"F", "G"}
        };
        MatrixGraph<String> mGraph = new MatrixGraph<>(vexs, edges);

//        mGraph.display();

        mGraph.dfs();
        System.out.println();
        mGraph.dfsNonRecursively();

        System.out.println();

        mGraph.bfs();
        System.out.println();
        mGraph.bfs1();

    }


}
