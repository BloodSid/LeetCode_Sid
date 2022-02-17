package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * NumberOfWaysToReconstructATreeSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 02/18/2022
 */
public class NumberOfWaysToReconstructATreeSolutionTest {
    NumberOfWaysToReconstructATreeSolution.Solution solution = new NumberOfWaysToReconstructATreeSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: checkWays(int[][] pairs)
     */
    @Test
    public void testCheckWays1() throws Exception {
        int[][] pairs = {{1, 2}, {2, 3}};
        int expected = 1;
        int actual = solution.checkWays(pairs);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckWays2() throws Exception {
        int[][] pairs = {{1, 2}, {2, 3}, {1, 3}};
        int expected = 2;
        int actual = solution.checkWays(pairs);
        assertEquals(expected, actual);
    }


}
