package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * FindLongestAwesomeSubstringSolution Tester.
 *
 * @author IronSid
 * @since 10/04/2021
 * @version 1.0
 */
public class FindLongestAwesomeSubstringSolutionTest {
    FindLongestAwesomeSubstringSolution.Solution solution = new FindLongestAwesomeSubstringSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: longestAwesome(String s)
    */
    @Test
    public void testLongestAwesome1() throws Exception {
        String s = "3242415";
        int expected = 5;
        int actual = solution.longestAwesome(s);
        assertEquals(expected, actual);
    }

    @Test
    public void testLongestAwesome2() throws Exception {
        String s = "12345678";
        int expected = 1;
        int actual = solution.longestAwesome(s);
        assertEquals(expected, actual);
    }

    @Test
    public void testLongestAwesome3() throws Exception {
        String s = "213123";
        int expected = 6;
        int actual = solution.longestAwesome(s);
        assertEquals(expected, actual);
    }

    @Test
    public void testLongestAwesome4() throws Exception {
        String s = "00";
        int expected = 2;
        int actual = solution.longestAwesome(s);
        assertEquals(expected, actual);
    }


}
