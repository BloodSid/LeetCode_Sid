package Contest0121.T3;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 01/21/2023
 * @version 1.0
 */
public class SolutionTest {
    Solution solution = new Solution();
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: maxScore(int[] nums1, int[] nums2, int k)
    */
    @Test
    public void testMaxScore() throws Exception {
        int[] nums1 = {23,16,20,7,3};
        int[] nums2 = {19,21,22,22,12};
        int k = 3;
        long expected = 1121;
        long actual = solution.maxScore(nums1, nums2, k);
        assertEquals(expected, actual);
    }


}
