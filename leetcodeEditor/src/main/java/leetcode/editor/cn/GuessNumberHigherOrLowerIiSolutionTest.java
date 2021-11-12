package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * GuessNumberHigherOrLowerIiSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 11/12/2021
 */
public class GuessNumberHigherOrLowerIiSolutionTest {
    GuessNumberHigherOrLowerIiSolution.Solution solution = new GuessNumberHigherOrLowerIiSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getMoneyAmount(int n)
     */
    @Test
    public void testGetMoneyAmount1() throws Exception {
        int n = 10;
        int expected = 16;
        int actual = solution.getMoneyAmount(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetMoneyAmount2() throws Exception {
        int n = 1;
        int expected = 0;
        int actual = solution.getMoneyAmount(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetMoneyAmount3() throws Exception {
        int n = 2;
        int expected = 1;
        int actual = solution.getMoneyAmount(n);
        assertEquals(expected, actual);
    }

}
