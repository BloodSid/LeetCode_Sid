package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * IntegerReplacementSolution Tester.
 *
 * @author IronSid
 * @since 11/19/2021
 * @version 1.0
 */
public class IntegerReplacementSolutionTest {
    IntegerReplacementSolution.Solution solution = new IntegerReplacementSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: integerReplacement(int n)
    */
    @Test
    public void testIntegerReplacement1() throws Exception {
        int n = 8;
        int expected = 3;
        int actual = solution.integerReplacement(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testIntegerReplacement2() throws Exception {
        int n = 7;
        int expected = 4;
        int actual = solution.integerReplacement(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testIntegerReplacement3() throws Exception {
        int n = 4;
        int expected = 2;
        int actual = solution.integerReplacement(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testIntegerReplacement4() throws Exception {
        int n = 10000;
        int expected = 16;
        int actual = solution.integerReplacement(n);
        assertEquals(expected, actual);
    }


}
