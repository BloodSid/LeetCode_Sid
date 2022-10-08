package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * ScoreOfParenthesesSolution Tester.
 *
 * @author IronSid
 * @since 10/09/2022
 * @version 1.0
 */
public class ScoreOfParenthesesSolutionTest {
    ScoreOfParenthesesSolution.Solution solution = new ScoreOfParenthesesSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: scoreOfParentheses(String s)
    */
    @Test
    public void testScoreOfParentheses() throws Exception {
        String s = "(())";
        int expected = 2;
        int actual = solution.scoreOfParentheses(s);
        assertEquals(expected, actual);
    }


}
