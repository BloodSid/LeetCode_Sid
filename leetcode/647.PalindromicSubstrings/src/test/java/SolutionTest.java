import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @create 2021-06-30 0:33
 */
public class SolutionTest {
    Solution solution = new Solution();
    @Test
    public void countSubstringsTest1() {
        String input = "aaa";
        int actual = solution.countSubstrings(input);
        int expected = 6;
        assertEquals(expected,actual);
    }
    @Test
    public void countSubstringsTest2() {
        String input = "abc";
        int actual = solution.countSubstrings(input);
        int expected = 3;
        assertEquals(expected,actual);
    }
}