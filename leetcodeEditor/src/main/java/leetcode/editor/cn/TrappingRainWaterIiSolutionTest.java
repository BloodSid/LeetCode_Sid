package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * TrappingRainWaterIiSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 11/04/2021
 */
public class TrappingRainWaterIiSolutionTest {
    TrappingRainWaterIiSolution.Solution solution = new TrappingRainWaterIiSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: trapRainWater(int[][] heightMap)
     */
    @Test
    public void testTrapRainWater1() throws Exception {
        int[][] heightMap = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        int expected = 4;
        int actual = solution.trapRainWater(heightMap);
        assertEquals(expected, actual);
    }

    @Test
    public void testTrapRainWater2() throws Exception {
        int[][] heightMap = {{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}};
        int expected = 10;
        int actual = solution.trapRainWater(heightMap);
        assertEquals(expected, actual);
    }

    @Test
    public void testTrapRainWater3() throws Exception {
        int[][] heightMap = {{12, 13, 1, 12}, {13, 4, 13, 12}, {13, 8, 10, 12}, {12, 13, 12, 12}, {13, 13, 13, 13}};
        int expected = 14;
        int actual = solution.trapRainWater(heightMap);
        assertEquals(expected, actual);
    }

}
