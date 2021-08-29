package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * SumOfAllOddLengthSubarraysSolution Tester.
 *
 * @author IronSid
 * @since 08/29/2021
 * @version 1.0
 */
public class SumOfAllOddLengthSubarraysSolutionTest {
    SumOfAllOddLengthSubarraysSolution.Solution solution = new SumOfAllOddLengthSubarraysSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: sumOddLengthSubarrays(int[] arr)
    */
    @Test
    public void testSumOddLengthSubarrays1() throws Exception {
        int[] arr = {1,4,2,5,3};
        int expected = 58;
        int actual = solution.sumOddLengthSubarrays(arr);
        assertEquals(expected, actual);
    }

    /**
    * Method: sumOddLengthSubarrays(int[] arr)
    */
    @Test
    public void testSumOddLengthSubarrays2() throws Exception {
        int[] arr = {1,2};
        int expected = 3;
        int actual = solution.sumOddLengthSubarrays(arr);
        assertEquals(expected, actual);
    }

    /**
    * Method: sumOddLengthSubarrays(int[] arr)
    */
    @Test
    public void testSumOddLengthSubarrays3() throws Exception {
        int[] arr = {10,11,12};
        int expected = 66;
        int actual = solution.sumOddLengthSubarrays(arr);
        assertEquals(expected, actual);
    }


}
