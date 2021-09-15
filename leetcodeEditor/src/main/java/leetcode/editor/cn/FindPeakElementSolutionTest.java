package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * FindPeakElementSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 09/15/2021
 */
public class FindPeakElementSolutionTest {
    FindPeakElementSolution.Solution solution = new FindPeakElementSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: findPeakElement(int[] nums)
     */
    @Test
    public void testFindPeakElemen1() throws Exception {
        int[] nums = {1, 2, 3, 1};
        int expected = 2;
        int actual = solution.findPeakElement(nums);
        assertEquals(expected, actual);
    }

    /**
     * Method: findPeakElement(int[] nums)
     */
    @Test
    public void testFindPeakElemen2() throws Exception {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int actual = solution.findPeakElement(nums);
        System.out.println(actual);
        boolean flag = (actual == 0 || (nums[actual] > nums[actual - 1])) &&
                (actual == nums.length - 1 || (nums[actual] > nums[actual + 1]));
        assertTrue(flag);
    }

    /**
     * Method: findPeakElement(int[] nums)
     */
    @Test
    public void testFindPeakElemen3() throws Exception {
        int[] nums = {3, 5, 4, 3, 4, 5, 7};
        int actual = solution.findPeakElement(nums);
        System.out.println(actual);
        boolean flag = (actual == 0 || (nums[actual] > nums[actual - 1])) &&
                (actual == nums.length - 1 || (nums[actual] > nums[actual + 1]));
        assertTrue(flag);
    }


}
