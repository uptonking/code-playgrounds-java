package yao.tutorial.stream;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static yao.tutorial.stream.FIleStream.*;

/**
 * FIleStream Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 17, 2017</pre>
 */
public class FIleStreamTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: readFileByByte(String strFilePath)
     */
    @Test
    public void testReadFileByByte() throws Exception {
        String filePath = FIleStream.class.getClassLoader().getResource("stream.txt").getPath();
        readFileByByte(filePath);
    }

    /**
     * Method: readFileByChar(String strFilePath)
     */
    @Test
    public void testReadFileByChar() throws Exception {
        String filePath = FIleStream.class.getClassLoader().getResource("stream.txt").getPath();
        readFileByChar(filePath);
    }

    /**
     * Method: writeFileByByte(String strFilePath)
     */
    @Test
    public void testWriteFileByByte() throws Exception {
        String inFilePath = FIleStream.class.getClassLoader().getResource("stream.txt").getPath();
        String outFilePath = FIleStream.class.getClassLoader().getResource("").getPath() + "outByte.txt";
//        System.out.println(FIleStream.class.getClassLoader().getResource("").getPath());
//        System.out.println(outFilePath);
        writeFileByByte(inFilePath, outFilePath);
    }

    /**
     * Method: writeFileByChar(String strFilePath)
     */
    @Test
    public void testWriteFileByChar() throws Exception {
        String outFilePath = FIleStream.class.getClassLoader().getResource("").getPath() + "outChar.txt";
        writeFileByChar(outFilePath);

    }

}
