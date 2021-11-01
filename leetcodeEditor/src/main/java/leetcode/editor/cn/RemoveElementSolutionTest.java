package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * RemoveElementSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 11/01/2021
 */
public class RemoveElementSolutionTest {
    RemoveElementSolution.Solution solution = new RemoveElementSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: removeElement(int[] nums, int val)
     */
    @Test
    public void testRemoveElement1() throws Exception {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int expected = 2;
        int[] expNums = {2, 2};
        int actual = solution.removeElement(nums, val);
        assertEquals(expected, actual);
        for (int i = 0; i < actual; i++) {
            assertEquals(Arrays.toString(nums), expNums[i], nums[i]);
        }
    }

    @Test
    public void testRemoveElement2() throws Exception {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int expected = 5;
        int[] expNums = {0, 1, 3, 0, 4};
        int actual = solution.removeElement(nums, val);
        assertEquals(expected, actual);
        for (int i = 0; i < actual; i++) {
            assertEquals(Arrays.toString(nums), expNums[i], nums[i]);
        }
    }

    @Test
    public void testRemoveElement3() throws Exception {
        int[] nums = {2, 2};
        int val = 2;
        int expected = 0;
        int[] expNums = {};
        int actual = solution.removeElement(nums, val);
        assertEquals(expected, actual);
        for (int i = 0; i < actual; i++) {
            assertEquals(Arrays.toString(nums), expNums[i], nums[i]);
        }
    }

}
