package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * PerfectRectangleSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 11/16/2021
 */
public class PerfectRectangleSolutionTest {
    PerfectRectangleSolution.Solution solution = new PerfectRectangleSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: isRectangleCover(int[][] rectangles)
     */
    @Test
    public void testIsRectangleCover1() throws Exception {
        int[][] rectangles = {{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
        boolean expected = true;
        boolean actual = solution.isRectangleCover(rectangles);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsRectangleCover2() throws Exception {
        int[][] rectangles = {{0, 0, 1, 1}, {0, 0, 1, 1}, {1, 1, 2, 2}, {1, 1, 2, 2}};
        boolean expected = false;
        boolean actual = solution.isRectangleCover(rectangles);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsRectangleCover3() throws Exception {
        int[][] rectangles = {{1, 1, 2, 3}, {1, 3, 2, 4}, {3, 1, 4, 2}, {3, 2, 4, 4}};
        boolean expected = false;
        boolean actual = solution.isRectangleCover(rectangles);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsRectangleCover4() throws Exception {
        int[][] rectangles = {{1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {3, 2, 4, 4}};
        boolean expected = false;
        boolean actual = solution.isRectangleCover(rectangles);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsRectangleCover5() throws Exception {
        int[][] rectangles = {{1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {2, 2, 4, 4}};
        boolean expected = false;
        boolean actual = solution.isRectangleCover(rectangles);
        assertEquals(expected, actual);
    }

}
