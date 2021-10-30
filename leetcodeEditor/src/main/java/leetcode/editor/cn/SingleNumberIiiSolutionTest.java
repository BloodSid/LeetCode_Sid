package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * SingleNumberIiiSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 10/30/2021
 */
public class SingleNumberIiiSolutionTest {
    SingleNumberIiiSolution.Solution solution = new SingleNumberIiiSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: singleNumber(int[] nums)
     */
    @Test
    public void testSingleNumber1() throws Exception {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] expected = {5, 3};
        int[] actual = solution.singleNumber(nums);
        Arrays.sort(expected);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSingleNumber2() throws Exception {
        int[] nums = {-1, 0};
        int[] expected = {0, -1};
        int[] actual = solution.singleNumber(nums);
        Arrays.sort(expected);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSingleNumber3() throws Exception {
        int[] nums = {0, 1};
        int[] expected = {0, 1};
        int[] actual = solution.singleNumber(nums);
        Arrays.sort(expected);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

}
