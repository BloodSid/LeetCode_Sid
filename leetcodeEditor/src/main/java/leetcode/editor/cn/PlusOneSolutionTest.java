package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * PlusOneSolution Tester.
 *
 * @author IronSid
 * @since 10/21/2021
 * @version 1.0
 */
public class PlusOneSolutionTest {
    PlusOneSolution.Solution solution = new PlusOneSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: plusOne(int[] digits)
    */
    @Test
    public void testPlusOne() throws Exception {
        int[] digits = {9};
        int[] expected = {1, 0};
        int[] actual = solution.plusOne(digits);
        assertArrayEquals(expected, actual);
    }


}
