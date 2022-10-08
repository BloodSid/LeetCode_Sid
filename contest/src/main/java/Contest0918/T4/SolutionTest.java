package Contest0918.T4;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 10/08/2022
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
    * Method: sumPrefixScores(String[] words)
    */
    @Test
    public void testSumPrefixScores() throws Exception {
        String[] words = {"abcd"};
        int[] expected = {4};
        int[] actual = solution.sumPrefixScores(words);
        assertArrayEquals(expected, actual);
    }


}
