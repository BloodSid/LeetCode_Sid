package Contest0619;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 06/19/2022
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
    * Method: greatestLetter(String s)
    */
    @Test
    public void testGreatestLetter() throws Exception {
    }

    /**
    * Method: minimumNumbers(int num, int k)
    */
    @Test
    public void testMinimumNumbers() throws Exception {
    }

    /**
    * Method: longestSubsequence(String s, int k)
    */
    @Test
    public void testLongestSubsequence() throws Exception {
    }

    /**
    * Method: sellingWood(int m, int n, int[][] prices)
    */
    @Test
    public void testSellingWood() throws Exception {
        int m = 3, n = 5;
        int[][] prices = {{1,4,2},{2,2,7},{2,1,3}};
        long expected = 19;
        long actual = solution.sellingWood(m, n, prices);
        assertEquals(expected, actual);
    }


}
