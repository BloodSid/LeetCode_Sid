package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * RemoveDuplicatesFromSortedArraySolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 11/01/2021
 */
public class RemoveDuplicatesFromSortedArraySolutionTest {
    RemoveDuplicatesFromSortedArraySolution.Solution solution = new RemoveDuplicatesFromSortedArraySolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: removeDuplicates(int[] nums)
     */
    @Test
    public void testRemoveDuplicates1() throws Exception {
        int[] nums = {1, 1, 2};
        int expected = 2;
        int[] expNums = {1, 2};
        int actual = solution.removeDuplicates(nums);
        assertEquals(expected, actual);
        for (int i = 0; i < actual; i++) {
            assertEquals(Arrays.toString(nums), expNums[i], nums[i]);
        }
    }

    @Test
    public void testRemoveDuplicates2() throws Exception {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int expected = 5;
        int[] expNums = {0, 1, 2, 3, 4};
        int actual = solution.removeDuplicates(nums);
        assertEquals(expected, actual);
        for (int i = 0; i < actual; i++) {
            assertEquals(Arrays.toString(nums), expNums[i], nums[i]);
        }
    }

    @Test
    public void testRemoveDuplicates3() throws Exception {
        int[] nums = {};
        int expected = 0;
        int[] expNums = {};
        int actual = solution.removeDuplicates(nums);
        assertEquals(expected, actual);
        for (int i = 0; i < actual; i++) {
            assertEquals(Arrays.toString(nums), expNums[i], nums[i]);
        }
    }

    @Test
    public void testRemoveDuplicates4() throws Exception {
        int[] nums = {1, 2, 3};
        int expected = 3;
        int[] expNums = {1, 2, 3};
        int actual = solution.removeDuplicates(nums);
        assertEquals(expected, actual);
        for (int i = 0; i < actual; i++) {
            assertEquals(Arrays.toString(nums), expNums[i], nums[i]);
        }
    }

    @Test
    public void testRemoveDuplicates5() throws Exception {
        int[] nums = {1, 1, 2, 3};
        int expected = 3;
        int[] expNums = {1, 2, 3};
        int actual = solution.removeDuplicates(nums);
        assertEquals(expected, actual);
        for (int i = 0; i < actual; i++) {
            assertEquals(Arrays.toString(nums), expNums[i], nums[i]);
        }
    }


}
