package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * MaximumEqualFrequencySolution Tester.
 *
 * @author IronSid
 * @since 08/18/2022
 * @version 1.0
 */
public class MaximumEqualFrequencySolutionTest {
    MaximumEqualFrequencySolution.Solution solution = new MaximumEqualFrequencySolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: maxEqualFreq(int[] nums)
    */
    @Test
    public void testMaxEqualFreq1() throws Exception {
        int[] nums = {2,2,1,1,5,3,3,5};
        int expected = 7;
        int actual = solution.maxEqualFreq(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testMaxEqualFreq2() throws Exception {
        int[] nums = {10,2,8,9,3,8,1,5,2,3,7,6};
        int expected = 8;
        int actual = solution.maxEqualFreq(nums);
        assertEquals(expected, actual);
    }


}
