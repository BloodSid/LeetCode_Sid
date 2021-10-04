package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * MinimumAsciiDeleteSumForTwoStringsSolution Tester.
 *
 * @author IronSid
 * @since 10/04/2021
 * @version 1.0
 */
public class MinimumAsciiDeleteSumForTwoStringsSolutionTest {
    MinimumAsciiDeleteSumForTwoStringsSolution.Solution solution = new MinimumAsciiDeleteSumForTwoStringsSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: minimumDeleteSum(String s1, String s2)
    */
    @Test
    public void testMinimumDeleteSum1() throws Exception {
        String s1 = "sea";
        String s2 = "eat";
        int expected = 231;
        int actual = solution.minimumDeleteSum(s1, s2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinimumDeleteSum2() throws Exception {
        String s1 = "delete";
        String s2 = "leet";
        int expected = 403;
        int actual = solution.minimumDeleteSum(s1, s2);
        assertEquals(expected, actual);
    }

}
