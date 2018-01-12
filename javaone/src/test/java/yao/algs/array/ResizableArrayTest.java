package yao.algs.array;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ResizableArray Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 10, 2018</pre>
 */
public class ResizableArrayTest {

        private ResizableArray<String> tech = new ResizableArray<>();
//    private ArrayList<String> tech = new ArrayList<>();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
        tech = null;
    }

    /**
     * Method: add(E e)
     */
    @Test
    public void testAddE() {
        tech.add("Apache Kylin");
        tech.add("webmagic");
        tech.add("hdfs");
        tech.add("spark");

        tech.remove("webmagic");
        tech.remove(2);
        tech.set(0,"kylin");

        System.out.println(Arrays.toString(tech.toArray(new String[tech.size()])));

//        for (String str : tech) {
//            System.out.println(str);
//        }

    }

    /**
     * Method: add(int index, E e)
     */
    @Test
    public void testAddForIndexE() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: remove(int index)
     */
    @Test
    public void testRemoveIndex() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: remove(Object o)
     */
    @Test
    public void testRemoveO() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: clear()
     */
    @Test
    public void testClear() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: size()
     */
    @Test
    public void testSize() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: isEmpty()
     */
    @Test
    public void testIsEmpty() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: contains(Object o)
     */
    @Test
    public void testContains() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: toArray(T[] t)
     */
    @Test
    public void testToArray() throws Exception {
//TODO: Test goes here...
    }


    /**
     * Method: trimToSize()
     */
    @Test
    public void testTrimToSize() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = ResizableArray.getClass().getMethod("trimToSize");
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

    /**
     * Method: grow()
     */
    @Test
    public void testGrow() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = ResizableArray.getClass().getMethod("grow");
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

    /**
     * Method: ensureCapacity(int eleSize)
     */
    @Test
    public void testEnsureCapacity() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = ResizableArray.getClass().getMethod("ensureCapacity", int.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

    /**
     * Method: ensureElementNotNull(Object o)
     */
    @Test
    public void testEnsureElementNotNull() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = ResizableArray.getClass().getMethod("ensureElementNotNull", Object.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

    /**
     * Method: rangeCheck(int index)
     */
    @Test
    public void testRangeCheck() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = ResizableArray.getClass().getMethod("rangeCheck", int.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

}
