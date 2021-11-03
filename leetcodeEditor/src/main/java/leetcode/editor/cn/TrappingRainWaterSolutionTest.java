package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * TrappingRainWaterSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 11/03/2021
 */
public class TrappingRainWaterSolutionTest {
    TrappingRainWaterSolution.Solution solution = new TrappingRainWaterSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: trap(int[] height)
     */
    @Test
    public void testTrap1() throws Exception {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expected = 6;
        int actual = solution.trap(height);
        assertEquals(expected, actual);
    }

    /**
     * Method: trap(int[] height)
     */
    @Test
    public void testTrap2() throws Exception {
        int[] height = {4, 2, 0, 3, 2, 5};
        int expected = 9;
        int actual = solution.trap(height);
        assertEquals(expected, actual);
    }


}
