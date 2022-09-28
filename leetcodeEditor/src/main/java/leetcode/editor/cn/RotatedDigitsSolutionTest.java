package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * RotatedDigitsSolution Tester.
 *
 * @author IronSid
 * @since 09/29/2022
 * @version 1.0
 */
public class RotatedDigitsSolutionTest {
    RotatedDigitsSolution.Solution solution = new RotatedDigitsSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: rotatedDigits(int n)
    */
    @Test
    public void testRotatedDigits() throws Exception {
        int n = (int) 1e9;
        int expected = 40333924;
        int actual = solution.rotatedDigits(n);
        assertEquals(expected, actual);
    }

}
