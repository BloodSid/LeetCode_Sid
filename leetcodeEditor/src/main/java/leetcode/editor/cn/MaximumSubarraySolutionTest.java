package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * MaximumSubarraySolution Tester.
 *
 * @author IronSid
 * @since 11/02/2021
 * @version 1.0
 */
public class MaximumSubarraySolutionTest {
    MaximumSubarraySolution.Solution solution = new MaximumSubarraySolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: maxSubArray(int[] nums)
    */
    @Test
    public void testMaxSubArray1() throws Exception {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int expected = 6;
        int actual = solution.maxSubArray(nums);
        assertEquals(expected, actual);
    }

    /**
    * Method: maxSubArray(int[] nums)
    */
    @Test
    public void testMaxSubArray2() throws Exception {
        int[] nums = {1};
        int expected = 1;
        int actual = solution.maxSubArray(nums);
        assertEquals(expected, actual);
    }

    /**
    * Method: maxSubArray(int[] nums)
    */
    @Test
    public void testMaxSubArray3() throws Exception {
        int[] nums = {5,4,-1,7,8};
        int expected = 23;
        int actual = solution.maxSubArray(nums);
        assertEquals(expected, actual);
    }

}
