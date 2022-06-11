package Contest0611;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 06/11/2022
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
    * Method: countSubarrays(int[] nums, long k)
    */
    @Test
    public void testCountSubarrays1() throws Exception {
        int[] nums = {1,1,1};
        long k = 6;
        long expected = 5;
        long actual = solution.countSubarrays(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void testCountSubarrays2() throws Exception {
        int[] nums = {2,1,4,3,5};
        long k = 10;
        long expected = 6;
        long actual = solution.countSubarrays(nums, k);
        assertEquals(expected, actual);
    }


}
