package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * ThirdMaximumNumberSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 10/06/2021
 */
public class ThirdMaximumNumberSolutionTest {
    ThirdMaximumNumberSolution.Solution solution = new ThirdMaximumNumberSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: thirdMax(int[] nums)
     */
    @Test
    public void testThirdMax1() throws Exception {
        int[] nums = {3, 2, 1};
        int expected = 1;
        int actual = solution.thirdMax(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testThirdMax2() throws Exception {
        int[] nums = {1, 2};
        int expected = 2;
        int actual = solution.thirdMax(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testThirdMax3() throws Exception {
        int[] nums = {2, 2, 3, 1};
        int expected = 1;
        int actual = solution.thirdMax(nums);
        assertEquals(expected, actual);
    }


}
