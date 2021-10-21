package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * ValidParenthesesSolution Tester.
 * @author IronSid
 * @version 1.0
 * @since 10/22/2021
 */
public class ValidParenthesesSolutionTest {
    ValidParenthesesSolution.Solution solution = new ValidParenthesesSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: isValid(String s)
     */
    @Test
    public void testIsValid1() throws Exception {
        String s = "()";
        boolean actual = solution.isValid(s);
        assertTrue(s, actual);
    }

    @Test
    public void testIsValid2() throws Exception {
        String s = "()[]{}";
        boolean actual = solution.isValid(s);
        assertTrue(s, actual);
    }

    @Test
    public void testIsValid3() throws Exception {
        String s = "(]";
        boolean actual = solution.isValid(s);
        assertFalse(s, actual);
    }

    @Test
    public void testIsValid4() throws Exception {
        String s = "([)]";
        boolean actual = solution.isValid(s);
        assertFalse(s, actual);
    }

    @Test
    public void testIsValid5() throws Exception {
        String s = "{[]}";
        boolean actual = solution.isValid(s);
        assertTrue(s, actual);
    }

    @Test
    public void testIsValid6() throws Exception {
        String s = "((";
        boolean actual = solution.isValid(s);
        assertFalse(s, actual);
    }

    @Test
    public void testIsValid7() throws Exception {
        String s = "))";
        boolean actual = solution.isValid(s);
        assertFalse(s, actual);
    }

}
