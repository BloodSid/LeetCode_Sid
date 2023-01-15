package Contest0115.T3;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 01/15/2023
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
    * Method: countGood(int[] nums, int k)
    */
    @Test
    public void testCountGood() throws Exception {
        int[] nums = {1,1,1,1,1};
        int k = 10;
        long expected = 1;
        long actual = solution.countGood(nums, k);
        assertEquals(expected, actual);
    }


}
