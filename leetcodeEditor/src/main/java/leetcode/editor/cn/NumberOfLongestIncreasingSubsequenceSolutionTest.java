package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * NumberOfLongestIncreasingSubsequenceSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 09/20/2021
 */
public class NumberOfLongestIncreasingSubsequenceSolutionTest {
    NumberOfLongestIncreasingSubsequenceSolution.Solution solution = new NumberOfLongestIncreasingSubsequenceSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: findNumberOfLIS(int[] nums)
     */
    @Test
    public void testFindNumberOfLIS1() throws Exception {
        int[] nums = {1, 3, 5, 4, 7};
        int expected = 2;
        int actual = solution.findNumberOfLIS(nums);
        assertEquals(expected, actual);
    }

    /**
     * Method: findNumberOfLIS(int[] nums)
     */
    @Test
    public void testFindNumberOfLIS2() throws Exception {
        int[] nums = {2, 2, 2, 2, 2};
        int expected = 5;
        int actual = solution.findNumberOfLIS(nums);
        assertEquals(expected, actual);
    }

    /**
     * Method: findNumberOfLIS(int[] nums)
     */
    @Test
    public void testFindNumberOfLIS3() throws Exception {
        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        int expected = 3;
        int actual = solution.findNumberOfLIS(nums);
        assertEquals(expected, actual);
    }


}
