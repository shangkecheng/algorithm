package test;

import algorithm.LongestSubstring;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * LongestSubstring Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>九月 27, 2017</pre>
 */
public class LongestSubstringTest {

    private LongestSubstring solution;


    @Before
    public void before() throws Exception {
        solution = new LongestSubstring();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: lengthOfLongestSubstring(String s)
     */
    @Test
    public void testLengthOfLongestSubstring() throws Exception {
        String test = "pwwkew";
        int actual =solution.lengthOfLongestSubstring(test);
        Assert.assertEquals("not happen",3,actual);
    }


} 
