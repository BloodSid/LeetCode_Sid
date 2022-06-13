package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * LongestPalindromicSubsequenceSolution Tester.
 *
 * @author IronSid
 * @since 06/13/2022
 * @version 1.0
 */
public class LongestPalindromicSubsequenceSolutionTest {
    LongestPalindromicSubsequenceSolution.Solution solution = new LongestPalindromicSubsequenceSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: longestPalindromeSubseq(String s)
    */
    @Test
    public void testLongestPalindromeSubseq() throws Exception {
        String input = "bbbab";
        int expected = 4;
        int actual = solution.longestPalindromeSubseq(input);
        assertEquals(expected, actual);
    }


}
