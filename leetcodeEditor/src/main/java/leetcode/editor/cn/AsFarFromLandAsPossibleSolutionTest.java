package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * AsFarFromLandAsPossibleSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 09/05/2021
 */
public class AsFarFromLandAsPossibleSolutionTest {
    AsFarFromLandAsPossibleSolution.Solution solution = new AsFarFromLandAsPossibleSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: maxDistance(int[][] grid)
     */
    @Test
    public void testMaxDistance1() throws Exception {
        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int expected = 2;
        int actual = solution.maxDistance(grid);
        assertEquals(expected, actual);
    }

    /**
     * Method: maxDistance(int[][] grid)
     */
    @Test
    public void testMaxDistance2() throws Exception {
        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int expected = 4;
        int actual = solution.maxDistance(grid);
        assertEquals(expected, actual);
    }

    /**
     * Method: maxDistance(int[][] grid)
     */
    @Test
    public void testMaxDistance3() throws Exception {
        int[][] grid = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int expected = -1;
        int actual = solution.maxDistance(grid);
        assertEquals(expected, actual);
    }

    /**
     * Method: maxDistance(int[][] grid)
     */
    @Test
    public void testMaxDistance4() throws Exception {
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int expected = -1;
        int actual = solution.maxDistance(grid);
        assertEquals(expected, actual);
    }


}
