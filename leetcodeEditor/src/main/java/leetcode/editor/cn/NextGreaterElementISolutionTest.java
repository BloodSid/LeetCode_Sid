package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * NextGreaterElementISolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 10/26/2021
 */
public class NextGreaterElementISolutionTest {
    NextGreaterElementISolution.Solution solution = new NextGreaterElementISolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: nextGreaterElement(int[] nums1, int[] nums2)
     */
    @Test
    public void testNextGreaterElement1() throws Exception {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] expected = {-1, 3, -1};
        int[] actual = solution.nextGreaterElement(nums1, nums2);
        assertArrayEquals(Arrays.toString(expected) + "\n" + Arrays.toString(actual), expected, actual);
    }

    @Test
    public void testNextGreaterElement2() throws Exception {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] expected = {3, -1};
        int[] actual = solution.nextGreaterElement(nums1, nums2);
        assertArrayEquals(Arrays.toString(expected) + "\n" + Arrays.toString(actual), expected, actual);
    }

}
