package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * SortColorsSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 11/05/2021
 */
public class SortColorsSolutionTest {
    SortColorsSolution.Solution solution = new SortColorsSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: sortColors(int[] nums)
     */
    @Test
    public void testSortColors1() throws Exception {
        int[] nums = {1, 2, 0};
        int[] expected = {0, 1, 2};
        solution.sortColors(nums);
        assertArrayEquals(nums, expected);
    }

}
