package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * NumberOfDigitOneSolution Tester.
 *
 * @author IronSid
 * @since 08/15/2022
 * @version 1.0
 */
public class NumberOfDigitOneSolutionTest {
    NumberOfDigitOneSolution.Solution solution = new NumberOfDigitOneSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: countDigitOne(int n)
    */
    @Test
    public void testCountDigitOne1() throws Exception {
        int n = 30;
        int expected = 13;
        int actual = solution.countDigitOne(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testCountDigitOne2() throws Exception {
        int n = 999;
        int expected = 300;
        int actual = solution.countDigitOne(n);
        assertEquals(expected, actual);
    }

}
