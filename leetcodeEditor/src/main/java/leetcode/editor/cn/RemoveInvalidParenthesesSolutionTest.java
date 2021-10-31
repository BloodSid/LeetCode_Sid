package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * RemoveInvalidParenthesesSolution Tester.
 *
 * @author IronSid
 * @since 10/27/2021
 * @version 1.0
 */
public class RemoveInvalidParenthesesSolutionTest {
    RemoveInvalidParenthesesSolution.Solution solution = new RemoveInvalidParenthesesSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: removeInvalidParentheses(String s)
    */
    @Test
    public void testRemoveInvalidParentheses1() throws Exception {
        String s = "()())()";
        String[] expected = {"(())()","()()()"};
        Arrays.sort(expected);
        String[] actual = solution.removeInvalidParentheses(s).toArray(new String[0]);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveInvalidParentheses2() throws Exception {
        String s = "(a)())()";
        String[] expected = {"(a())()","(a)()()"};
        Arrays.sort(expected);
        String[] actual = solution.removeInvalidParentheses(s).toArray(new String[0]);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveInvalidParentheses3() throws Exception {
        String s = ")(";
        String[] expected = {""};
        Arrays.sort(expected);
        String[] actual = solution.removeInvalidParentheses(s).toArray(new String[0]);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveInvalidParentheses4() throws Exception {
        String s = "()";
        String[] expected = {"()"};
        Arrays.sort(expected);
        String[] actual = solution.removeInvalidParentheses(s).toArray(new String[0]);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }


}
