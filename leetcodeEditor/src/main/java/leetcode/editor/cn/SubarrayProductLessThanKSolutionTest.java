package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * SubarrayProductLessThanKSolution Tester.
 *
 * @author IronSid
 * @since 04/08/2022
 * @version 1.0
 */
public class SubarrayProductLessThanKSolutionTest {
    SubarrayProductLessThanKSolution.Solution solution = new SubarrayProductLessThanKSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: numSubarrayProductLessThanK(int[] nums, int k)
    */
    @Test
    public void testNumSubarrayProductLessThanK() throws Exception {
        int[] nums = {57,44,92,28,66,60,37,33,52,38,29,76,8,75,22};
        int k = 18;
        int expected = 1;
        int actual = solution.numSubarrayProductLessThanK(nums, k);
        assertEquals(expected, actual);
    }


}
