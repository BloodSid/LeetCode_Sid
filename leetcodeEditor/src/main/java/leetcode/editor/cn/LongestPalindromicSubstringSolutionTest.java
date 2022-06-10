package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * LongestPalindromicSubstringSolution Tester.
 *
 * @author IronSid
 * @since 06/10/2022
 * @version 1.0
 */
public class LongestPalindromicSubstringSolutionTest {
    LongestPalindromicSubstringSolution.Solution solution = new LongestPalindromicSubstringSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: longestPalindrome(String s)
    */
    @Test
    public void testLongestPalindrome1() throws Exception {
        String s = "babad";
        String expected = "bab";
        String actual = solution.longestPalindrome(s);
        assertEquals("长度错误", expected.length(), actual.length());
        assertTrue("不是回文", isPalindrome(actual));
    }

    @Test
    public void testLongestPalindrome2() throws Exception {
        String s = "cbbd";
        String expected = "bb";
        String actual = solution.longestPalindrome(s);
        assertEquals("长度错误", expected.length(), actual.length());
        assertTrue("不是回文", isPalindrome(actual));
    }

    @Test
    public void testLongestPalindrome3() throws Exception {
        String s = "ccc";
        String expected = "ccc";
        String actual = solution.longestPalindrome(s);
        assertEquals("长度错误", expected.length(), actual.length());
        assertTrue("不是回文", isPalindrome(actual));
    }

    @Test
    public void testLongestPalindrome4() throws Exception {
        String s = "ccccc";
        String expected = "ccccc";
        String actual = solution.longestPalindrome(s);
        assertEquals("长度错误", expected.length(), actual.length());
        assertTrue("不是回文", isPalindrome(actual));
    }

    private boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0, j = ch.length - 1; i < j; i++, j--) {
            if (ch[i] != ch[j]) return false;
        }
        return true;
    }


}
