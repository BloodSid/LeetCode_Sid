package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * HIndexSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 10/18/2021
 */
public class HIndexSolutionTest {
    HIndexSolution.Solution solution = new HIndexSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: hIndex(int[] citations)
     */
    @Test
    public void testHIndex1() throws Exception {
        int[] citations = {3, 0, 6, 1, 5};
        int expected = 3;
        int actual = solution.hIndex(citations);
        assertEquals(expected, actual);
    }

    @Test
    public void testHIndex2() throws Exception {
        int[] citations = {1, 3, 1};
        int expected = 1;
        int actual = solution.hIndex(citations);
        assertEquals(expected, actual);
    }

    @Test
    public void testHIndex3() throws Exception {
        int[] citations = {1};
        int expected = 1;
        int actual = solution.hIndex(citations);
        assertEquals(expected, actual);
    }

}
