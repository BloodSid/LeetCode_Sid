package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * OutOfBoundaryPathsSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 08/15/2021
 */
public class OutOfBoundaryPathsSolutionTest {
    OutOfBoundaryPathsSolution.Solution solution = new OutOfBoundaryPathsSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: findPaths(int m, int n, int maxMove, int startRow, int startColumn)
     */
    @Test
    public void testFindPaths1() throws Exception {
        int m = 2;
        int n = 2;
        int maxMove = 2;
        int startRow = 0;
        int startColumn = 0;
        int expected = 6;
        int actual = solution.findPaths(m, n, maxMove, startRow, startColumn);
        assertEquals(expected, actual);
    }

    /**
     * Method: findPaths(int m, int n, int maxMove, int startRow, int startColumn)
     */
    @Test
    public void testFindPaths2() throws Exception {
        int m = 50;
        int n = 50;
        int maxMove = 50;
        int startRow = 25;
        int startColumn = 24;
        int expected = 276775132;
        int actual = solution.findPaths(m, n, maxMove, startRow, startColumn);
        assertEquals(expected, actual);
    }


}
