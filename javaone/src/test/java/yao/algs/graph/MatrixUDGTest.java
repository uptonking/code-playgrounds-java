package yao.algs.graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * MatrixUDG Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 14, 2018</pre>
 */
public class MatrixUDGTest {

    MatrixUDG udg;


    @Before
    public void before() throws Exception {
        String[] vex = "A,B,C,D,E,F,G".split(",");
        String[][] edge = {{"A", "B"}, {"A", "C"}, {"A", "D"}, {"A", "E"}, {"A", "F"}, {"C", "B"}, {"D", "G"}};
        udg = new MatrixUDG(vex, edge);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: print()
     */
    @Test
    public void testPrint() throws Exception {
        udg.print();
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
     * Method: dfs(int v)
     */
    @Test
    public void testDfs() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: bfs(int v)
     */
    @Test
    public void testBfs() throws Exception {
//TODO: Test goes here...
    }


    /**
     * Method: getPosition(String str)
     */
    @Test
    public void testGetPosition() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = MatrixUDG.getClass().getMethod("getPosition", String.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

}
