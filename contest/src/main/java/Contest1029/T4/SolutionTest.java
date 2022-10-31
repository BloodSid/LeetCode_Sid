package Contest1029.T4;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 10/31/2022
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
    * Method: secondGreaterElement(int[] nums)
    */
    @Test
    public void testSecondGreaterElement() throws Exception {
        int[] nums = {272,238,996,406,763,164,102,948,217,760,609,700,848,637,748,718,469,449,502,703,292,86,91,551,699,293,244,406,22,968,434,805,910,927,623,79,108,541,411};
        int[] expected = {406,406,-1,948,848,217,217,-1,609,968,848,748,910,718,805,805,703,703,551,805,699,551,699,968,805,968,968,434,434,-1,910,927,-1,-1,-1,541,411,-1,-1};
        int[] actual = solution.secondGreaterElement(nums);
        assertArrayEquals(expected, actual);
    }


}
