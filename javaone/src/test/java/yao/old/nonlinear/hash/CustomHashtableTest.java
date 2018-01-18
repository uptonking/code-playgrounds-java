package yao.old.nonlinear.hash;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
* CustomHashtable Tester.
*
* @author <Authors name>
* @since <pre>Jun 30, 2017</pre>
* @version 1.0
*/
public class CustomHashtableTest {

@Before
public void before() throws Exception {
}

@After
public void after() throws Exception {
}

/**
*
* Method: size()
*
*/
@Test
public void testSize() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: put(K key, V value)
*
*/
@Test
public void testPut() throws Exception {
    CustomHashtable<String, String> hashtable = new CustomHashtable<String, String>();
    for (int i = 0; i < 9; i++) {
        hashtable.put("lyx" + i, "lyx" + i);
    }

    hashtable.put("lyx0", "aaaaaaaaaaaaaaaaaaaaa");
    hashtable.put("lyx0", "aaaaaaaaaaaaaaaaaaaaa");
    hashtable.put("lyx0", "aaaaaaaaaaaaaaaaaaaaa");
    hashtable.put("lyx0", "aabbccdd");

    System.out.println(hashtable.get("lyx0"));
    System.out.println(hashtable.get("lyx1"));
    System.out.println(hashtable.get("lyx2"));
    System.out.println(hashtable.get("lyx3"));}

/**
*
* Method: get(Object key)
*
*/
@Test
public void testGet() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: rehash()
*
*/
@Test
public void testRehash() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: getKey()
*
*/
@Test
public void testGetKey() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: getValue()
*
*/
@Test
public void testGetValue() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: setValue(V value)
*
*/
@Test
public void testSetValue() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: equals(Object o)
*
*/
@Test
public void testEquals() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: hashCode()
*
*/
@Test
public void testHashCode() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: toString()
*
*/
@Test
public void testToString() throws Exception {
//TODO: Test goes here...
}


/**
*
* Method: addEntry(int hash, K key, V value, int index)
*
*/
@Test
public void testAddEntry() throws Exception {
//TODO: Test goes here...
/*
try {
   Method method = CustomHashtable.getClass().getMethod("addEntry", int.class, K.class, V.class, int.class);
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}
*/
}

}
