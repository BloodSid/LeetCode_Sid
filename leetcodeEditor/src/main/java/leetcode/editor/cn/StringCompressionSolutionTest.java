package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * StringCompressionSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 08/21/2021
 */
public class StringCompressionSolutionTest {
    StringCompressionSolution.Solution solution = new StringCompressionSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: compress(char[] chars)
     */
    @Test
    public void testCompress1() throws Exception {

        int expected = 6;
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] res = {'a', '2', 'b', '2', 'c', '3'};
        int actual = solution.compress(chars);
        assertEquals(expected, actual);
        for (int i = 0; i < expected; i++) {
            assertEquals(chars[i], res[i]);
        }
    }

    @Test
    public void testCompress2() throws Exception {

        int expected = 1;
        char[] chars = {'a'};
        char[] res = {'a'};
        int actual = solution.compress(chars);
        assertEquals(expected, actual);
        for (int i = 0; i < expected; i++) {
            assertEquals(chars[i], res[i]);
        }
    }

    @Test
    public void testCompress3() throws Exception {

        int expected = 4;
        char[] chars = {'a', 'b','b','b','b','b','b','b','b','b','b','b','b'};
        char[] res = {'a', 'b', '1', '2'};
        int actual = solution.compress(chars);
        assertEquals(expected, actual);
        for (int i = 0; i < expected; i++) {
            assertEquals(chars[i], res[i]);
        }
    }
    @Test
    public void testCompress4() throws Exception {

        int expected = 3;
        char[] chars = {'a', 'a', 'a', 'd'};
        char[] res = {'a', '3', 'd'};
        int actual = solution.compress(chars);
        assertEquals(expected, actual);
        for (int i = 0; i < expected; i++) {
            assertEquals(chars[i], res[i]);
        }
    }

}
