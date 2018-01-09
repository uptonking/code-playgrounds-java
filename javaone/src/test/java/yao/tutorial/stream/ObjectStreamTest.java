package yao.tutorial.stream;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import yao.io.FIleStream;

import static yao.io.ObjectStream.writeReadObjectStream;

/**
 * ObjectStream Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 17, 2017</pre>
 */
public class ObjectStreamTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: writeReadObjectStream(String oPath)
     */
    @Test
    public void testWriteReadObjectStream() throws Exception {
        String oPath = FIleStream.class.getClassLoader().getResource("").getPath() + "obj.txt";
        writeReadObjectStream(oPath);

    }


}
