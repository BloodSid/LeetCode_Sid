package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * TwoKeysKeyboardSolution Tester.
 *
 * @author IronSid
 * @since 09/19/2021
 * @version 1.0
 */
public class TwoKeysKeyboardSolutionTest {
    TwoKeysKeyboardSolution.Solution solution = new TwoKeysKeyboardSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: minSteps(int n)
    */
    @Test
    public void testMinSteps1() throws Exception {
        int input = 1;
        int expected = 0;
        int actual = solution.minSteps(input);
        assertEquals(expected, actual);
    }

    /**
    * Method: minSteps(int n)
    */
    @Test
    public void testMinSteps2() throws Exception {
        int input = 10;
        int expected = 7;
        int actual = solution.minSteps(input);
        assertEquals(expected, actual);
    }

    /**
    * Method: minSteps(int n)
    */
    @Test
    public void testMinSteps3() throws Exception {
        int input = 3;
        int expected = 3;
        int actual = solution.minSteps(input);
        assertEquals(expected, actual);
    }


}
