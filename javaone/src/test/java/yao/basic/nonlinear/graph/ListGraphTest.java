package yao.basic.nonlinear.graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * ListGraph Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 30, 2017</pre>
 */
public class ListGraphTest {

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
     * Method: addToListTail(ListNode list, ListNode node)
     */
    @Test
    public void testAddToListTail() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: dfs()
     */
    @Test
    public void testDfs() throws Exception {
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
        ListGraph<String> listGraph = new ListGraph<>(vexs, edges);

        listGraph.display();

        listGraph.dfs();
        listGraph.dfsNonRecursively();
        listGraph.bfs();
    }

    /**
     * Method: bfs()
     */
    @Test
    public void testBfs() throws Exception {
//TODO: Test goes here... 
    }


} 
