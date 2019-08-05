package yao.algs.map;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.HashMap;

/**
 * ArrayMap Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 17, 2018</pre>
 */
public class ArrayMapTest {

    private ArrayMap<String, Integer> arrMap;
    private HashMap<String, Integer> hashMap;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: get(Object key)
     */
    @Test
    public void testGet() throws Exception {

        arrMap = new ArrayMap<>(23);
        arrMap.put("aa", 11);
        arrMap.put("bb", 22);
        arrMap.put("cc", 33);
        arrMap.put("dd", 44);
        arrMap.put("ee", 55);
        arrMap.put("ee", 56);
        System.out.println(arrMap.get("dd"));
        System.out.println(arrMap.get("ee"));
        System.out.println(arrMap.get("222"));

//        hashMap = new HashMap<>();
//        hashMap.put("100", 100);
//        hashMap.put("abc", 10000);
//
//        System.out.println(hashMap);
//        System.out.println(hashMap.get("abc"));
//
//        hashMap.put("abc", 40);
//        System.out.println(hashMap.get("abc"));
//        hashMap.put("001", 1);
//        System.out.println(hashMap);

    }


    /**
     * Method: put(K key, V value)
     */
    @Test
    public void testPut() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: containsKey(Object key)
     */
    @Test
    public void testContainsKey() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: containsValue(Object value)
     */
    @Test
    public void testContainsValue() throws Exception {
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
     * Method: remove(Object key)
     */
    @Test
    public void testRemove() throws Exception {
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
     * Method: clear()
     */
    @Test
    public void testClear() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: grow()
     */
    @Test
    public void testGrow() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: getKey()
     */
    @Test
    public void testGetKey() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: getValue()
     */
    @Test
    public void testGetValue() throws Exception {
//TODO: Test goes here...
    }


    /**
     * Method: getIndex(Object key)
     */
    @Test
    public void testGetIndex() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = ArrayMap.getClass().getMethod("getIndex", Object.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

    /**
     * Method: getEntryValue(Entry<K, V> entry, Object key)
     */
    @Test
    public void testGetEntryValue() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = ArrayMap.getClass().getMethod("getEntryValue", Entry<K,.class, Object.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

    /**
     * Method: hashAgain(Entry<K, V>[] newArray, TwoWayList<Entry<K, V>> list)
     */
    @Test
    public void testHashAgain() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = ArrayMap.getClass().getMethod("hashAgain", Entry<K,.class, TwoWayList<Entry<K,.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

    /**
     * Method: findEntry(Entry<K, V> entry, TwoWayList<Entry<K, V>> entryList)
     */
    @Test
    public void testFindEntry() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = ArrayMap.getClass().getMethod("findEntry", Entry<K,.class, TwoWayList<Entry<K,.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
    }

}
