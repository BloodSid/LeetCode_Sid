package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * PartitionToKEqualSumSubsetsSolution Tester.
 *
 * @author IronSid
 * @since 09/20/2022
 * @version 1.0
 */
public class PartitionToKEqualSumSubsetsSolutionTest {
    PartitionToKEqualSumSubsetsSolution.Solution solution = new PartitionToKEqualSumSubsetsSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: canPartitionKSubsets(int[] nums, int k)
    */
    @Test
    public void testCanPartitionKSubsets() throws Exception {
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;
        boolean expected = true;
        boolean actual = solution.canPartitionKSubsets(nums, k);
        assertEquals(expected, actual);
    }



}
