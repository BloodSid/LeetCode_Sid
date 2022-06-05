package Contest0605;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 06/05/2022
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
    * Method: minMaxGame(int[] nums)
    */
    @Test
    public void testMinMaxGame() throws Exception {
        int[] nums = {1,3,5,2,4,8,2,2};
        int expected = 1;
        int actual = solution.minMaxGame(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void testPartitionArray() throws Exception {
        int[] nums = {3,6,1,2,5};
        int k = 2;
        int expected = 2;
        int actual = solution.partitionArray(nums, k);
        assertEquals(expected, actual);
    }


}
