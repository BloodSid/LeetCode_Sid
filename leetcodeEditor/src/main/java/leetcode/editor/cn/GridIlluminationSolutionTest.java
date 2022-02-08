package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * GridIlluminationSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 02/08/2022
 */
public class GridIlluminationSolutionTest {
    GridIlluminationSolution.Solution solution = new GridIlluminationSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: gridIllumination(int n, int[][] lamps, int[][] queries)
     */
    @Test
    public void testGridIllumination1() throws Exception {
        int n = 5;
        int[][] lamps = {{0, 0}, {4, 4}};
        int[][] queries = {{1, 1}, {1, 1}};
        int[] expected = {1, 1};
        int[] actual = solution.gridIllumination(n, lamps, queries);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGridIllumination2() throws Exception {
        int n = 5;
        int[][] lamps = {{0, 0}, {0, 4}};
        int[][] queries = {{0, 4}, {0, 1}, {1, 4}};
        int[] expected = {1, 1, 0};
        int[] actual = solution.gridIllumination(n, lamps, queries);
        assertArrayEquals(expected, actual);
    }


}
