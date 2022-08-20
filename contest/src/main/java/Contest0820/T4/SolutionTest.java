package Contest0820.T4;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 08/20/2022
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
    * Method: maximumSegmentSum(int[] nums, int[] removeQueries)
    */
    @Test
    public void testMaximumSegmentSum1() throws Exception {
        int[] nums = {1,2,5,6,1};
        int[] removeQueries = {0,3,2,4,1};
        long[] expected = {14,7,2,2,0};
        long[] actual = solution.maximumSegmentSum(nums, removeQueries);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMaximumSegmentSum2() throws Exception {
        int[] nums = {1,2,3,4,5};
        int[] removeQueries = {3,0,4,2,1};
        long[] expected = {6,5,5,2,0};
        long[] actual = solution.maximumSegmentSum(nums, removeQueries);
        assertArrayEquals(expected, actual);
    }


}
