package Contest1001.T4;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 10/01/2022
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
    * Method: numberOfPairs(int[] nums1, int[] nums2, int diff)
    */
    @Test
    public void testNumberOfPairs() throws Exception {
        int[] nums1 = {3,2,5};
        int[] nums2 = {2,2,1};
        int diff = 1;
        long expected = 3;
        long actual = solution.numberOfPairs(nums1, nums2, diff);
        assertEquals(expected, actual);
    }


}
