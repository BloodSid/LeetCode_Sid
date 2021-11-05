package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * MajorityElementSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 11/05/2021
 */
public class MajorityElementSolutionTest {
    MajorityElementSolution.Solution solution = new MajorityElementSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: majorityElement(int[] nums)
     */
    @Test
    public void testMajorityElement1() throws Exception {
        int[] nums = {3, 2, 3};
        int expected = 3;
        int actual = solution.majorityElement(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testMajorityElement2() throws Exception {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int expected = 2;
        int actual = solution.majorityElement(nums);
        assertEquals(expected, actual);
    }

}
