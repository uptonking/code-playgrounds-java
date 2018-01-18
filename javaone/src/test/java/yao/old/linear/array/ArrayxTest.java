package yao.old.linear.array;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertTrue;

/**
 * Arrayx Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 23, 2017</pre>
 */
public class ArrayxTest {

    Arrayx a1;

    @Before
    public void before() throws Exception {

        a1 = new Arrayx(100);

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: get(int i)
     */
    @Test
    public void testGet() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: search(int x)
     */
    @Test
    public void testSearch() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: add(int x, int i)
     */
    @Test
    public void testAdd() throws Exception {
        assertTrue(a1.add(2, 0));
        assertTrue(a1.add(3, 1));

        a1.display();

    }

    /**
     * Method: remove(int i)
     */
    @Test
    public void testRemove() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: union(Arrayx a, Arrayx b)
     */
    @Test
    public void testUnion() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: intersection(Arrayx a, Arrayx b)
     */
    @Test
    public void testIntersection() throws Exception {
//TODO: Test goes here...
    }


    /**
     * Method: getArray()
     */
    @Test
    public void testGetArray() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = Arrayx.getClass().getMethod("getArray");
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

}
