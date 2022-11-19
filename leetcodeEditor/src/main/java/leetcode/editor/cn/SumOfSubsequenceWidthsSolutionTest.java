package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * SumOfSubsequenceWidthsSolution Tester.
 *
 * @author IronSid
 * @since 11/19/2022
 * @version 1.0
 */
public class SumOfSubsequenceWidthsSolutionTest {
    SumOfSubsequenceWidthsSolution.Solution solution = new SumOfSubsequenceWidthsSolution.Solution();
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: sumSubseqWidths(int[] nums)
    */
    @Test
    public void testSumSubseqWidths() throws Exception {
        int[] nums = {2, 1, 3};
        int expected = 6;
        int actual = solution.sumSubseqWidths(nums);
        assertEquals(expected, actual);
    }


}
