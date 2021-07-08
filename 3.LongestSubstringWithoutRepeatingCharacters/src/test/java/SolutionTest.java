import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @create 2021-07-08 20:54
 */
public class SolutionTest {
    Solution s= new Solution();
    @Test
    public void lengthOfLongestSubstringTest1() {
        String input = "abcabcbb";
        int expected = 3;
        assertEquals(expected,s.lengthOfLongestSubstring(input));
    }
    @Test
    public void lengthOfLongestSubstringTest2() {
        String input = "bbbbb";
        int expected = 1;
        assertEquals(expected,s.lengthOfLongestSubstring(input));
    }
    @Test
    public void lengthOfLongestSubstringTest3() {
        String input = "pwwkew";
        int expected = 3;
        assertEquals(expected,s.lengthOfLongestSubstring(input));
    }
    @Test
    public void lengthOfLongestSubstringTest4() {
        String input = "";
        int expected = 0;
        assertEquals(expected,s.lengthOfLongestSubstring(input));
    }
    @Test
    public void lengthOfLongestSubstringTest6() {
        String input = "aa";
        int expected = 1;
        assertEquals(expected,s.lengthOfLongestSubstring(input));
    }
    @Test
    public void lengthOfLongestSubstringTest7() {
        String input = "ab";
        int expected = 2;
        assertEquals(expected,s.lengthOfLongestSubstring(input));
    }
}