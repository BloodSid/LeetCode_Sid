package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * ValidPerfectSquareSolution Tester.
 *
 * @author IronSid
 * @since 11/04/2021
 * @version 1.0
 */
public class ValidPerfectSquareSolutionTest {
    ValidPerfectSquareSolution.Solution solution = new ValidPerfectSquareSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: isPerfectSquare(int num)
    */
    @Test
    public void testIsPerfectSquare1() throws Exception {
        int num = 16;
        boolean expected = true;
        boolean actual = solution.isPerfectSquare(num);
        assertEquals(Integer.toString(num), expected, actual);
    }

    @Test
    public void testIsPerfectSquare2() throws Exception {
        int num = 14;
        boolean expected = false;
        boolean actual = solution.isPerfectSquare(num);
        assertEquals(Integer.toString(num), expected, actual);
    }

    @Test
    public void testIsPerfectSquare3() throws Exception {
        int num = 1;
        boolean expected = true;
        boolean actual = solution.isPerfectSquare(num);
        assertEquals(Integer.toString(num), expected, actual);
    }

    @Test
    public void testIsPerfectSquare4() throws Exception {
        int num = 5;
        boolean expected = false;
        boolean actual = solution.isPerfectSquare(num);
        assertEquals(Integer.toString(num), expected, actual);
    }


}
