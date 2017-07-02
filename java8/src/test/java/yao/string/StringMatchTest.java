package yao.string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * StringMatch Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jul 1, 2017</pre>
 */
public class StringMatchTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: matchViolently(char[] s, char[] p)
     */
    @Test
    public void testMatchViolently() throws Exception {

        String s1 = "bbc abcdab abcdabcdabde";
        String p1 = "abcdabd";

        String s2 = " abccd bcdde";
        String p2 = " bcd";

        StringMatch matcher = new StringMatch();

        int a1 = matcher.matchViolently(s1, p1);
        System.out.println(a1);


//        int a2 = matcher.matchKMP(s1, p1);
        int a2 = matcher.matchKMP(s2, p2);
        System.out.println(a2);


    }

    /**
     * Method: matchKMP(String s, String p)
     */
    @Test
    public void testMatchKMP() throws Exception {
//TODO: Test goes here... 
    }


} 
