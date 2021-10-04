package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * NumberOfIslandsSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 10/04/2021
 */
public class NumberOfIslandsSolutionTest {
    NumberOfIslandsSolution.Solution solution = new NumberOfIslandsSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: numIslands(char[][] grid)
     */
    @Test
    public void testNumIslands1() throws Exception {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                         {'1', '1', '0', '1', '0'},
                         {'1', '1', '0', '0', '0'},
                         {'0', '0', '0', '0', '0'}};
        int expected = 1;
        int actual = solution.numIslands(grid);
        assertEquals(expected, actual);
    }
    @Test
    public void testNumIslands2() throws Exception {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                         {'1', '1', '0', '0', '0'},
                         {'0', '0', '1', '0', '0'},
                         {'0', '0', '0', '1', '1'}};
        int expected = 3;
        int actual = solution.numIslands(grid);
        assertEquals(expected, actual);
    }


}
