package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * ConstructTheRectangleSolution Tester.
 *
 * @author IronSid
 * @since 10/23/2021
 * @version 1.0
 */
public class ConstructTheRectangleSolutionTest {
    ConstructTheRectangleSolution.Solution solution = new ConstructTheRectangleSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: constructRectangle(int area)
    */
    @Test
    public void testConstructRectangle1() throws Exception {
        int area = 4;
        int[] expected = {2, 2};
        int[] actual = solution.constructRectangle(area);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testConstructRectangle2() throws Exception {
        int area = 5;
        int[] expected = {5, 1};
        int[] actual = solution.constructRectangle(area);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testConstructRectangle3() throws Exception {
        int area = 10000000;
        int[] expected = {3200, 3125};
        int[] actual = solution.constructRectangle(area);
        assertArrayEquals(expected, actual);
    }

}
