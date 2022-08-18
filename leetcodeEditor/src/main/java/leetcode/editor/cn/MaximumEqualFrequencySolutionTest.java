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
    public void testMaxEqualFreq() throws Exception {
        int[] nums = {2,2,1,1,5,3,3,5};
        int expected = 7;
        int actual = solution.maxEqualFreq(nums);
        assertEquals(expected, actual);
    }


}
