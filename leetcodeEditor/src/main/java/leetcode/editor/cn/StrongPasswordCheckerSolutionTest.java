package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * StrongPasswordCheckerSolution Tester.
 *
 * @author IronSid
 * @since 04/02/2022
 * @version 1.0
 */
public class StrongPasswordCheckerSolutionTest {
    StrongPasswordCheckerSolution.Solution solution = new StrongPasswordCheckerSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: strongPasswordChecker(String password)
    */
    @Test
    public void testStrongPasswordChecker1() throws Exception {
        String password = "AAAAA";
        int expected = 2;
        int actual = solution.strongPasswordChecker(password);
        assertEquals(expected, actual);
    }

    @Test
    public void testStrongPasswordChecker2() throws Exception {
        String password = "AAAaaa0001";
        int expected = 3;
        int actual = solution.strongPasswordChecker(password);
        assertEquals(expected, actual);
    }

    @Test
    public void testStrongPasswordChecker3() throws Exception {
        String password = "ABCDEFG";
        int expected = 2;
        int actual = solution.strongPasswordChecker(password);
        assertEquals(expected, actual);
    }

    @Test
    public void testStrongPasswordChecker4() throws Exception {
        String password = "bbaaaaaaaaaaaaaaacccccc";
        int expected = 8;
        int actual = solution.strongPasswordChecker(password);
        assertEquals(expected, actual);
    }



}
