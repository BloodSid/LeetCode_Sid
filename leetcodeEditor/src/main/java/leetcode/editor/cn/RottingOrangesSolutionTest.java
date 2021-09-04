package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * RottingOrangesSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 09/05/2021
 */
public class RottingOrangesSolutionTest {
    RottingOrangesSolution.Solution solution = new RottingOrangesSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: orangesRotting(int[][] grid)
     */
    @Test
    public void testOrangesRotting1() throws Exception {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int expected = 4;
        int actual = solution.orangesRotting(grid);
        assertEquals(expected, actual);
    }

    /**
     * Method: orangesRotting(int[][] grid)
     */
    @Test
    public void testOrangesRotting2() throws Exception {
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int expected = -1;
        int actual = solution.orangesRotting(grid);
        assertEquals(expected, actual);
    }
    /**
     * Method: orangesRotting(int[][] grid)
     */
    @Test
    public void testOrangesRotting3() throws Exception {
        int[][] grid = {{0, 2}};
        int expected = 0;
        int actual = solution.orangesRotting(grid);
        assertEquals(expected, actual);
    }


}
