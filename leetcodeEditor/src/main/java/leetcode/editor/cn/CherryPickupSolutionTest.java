package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * CherryPickupSolution Tester.
 *
 * @author IronSid
 * @since 07/10/2022
 * @version 1.0
 */
public class CherryPickupSolutionTest {
    CherryPickupSolution.Solution solution = new CherryPickupSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: cherryPickup(int[][] grid)
    */
    @Test
    public void testCherryPickup1() throws Exception {
        int[][] grid = {{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}};
        int expected = 0;
        int actual = solution.cherryPickup(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void testCherryPickup2() throws Exception {
        int[][] grid = {{0,1,-1},{1,0,-1},{1,1,1}};
        int expected = 5;
        int actual = solution.cherryPickup(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void testCherryPickup3() throws Exception {
        int[][] grid = {{1}};
        int expected = 1;
        int actual = solution.cherryPickup(grid);
        assertEquals(expected, actual);
    }

}
