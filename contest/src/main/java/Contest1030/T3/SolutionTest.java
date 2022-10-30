package Contest1030.T3;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 10/30/2022
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
    * Method: makeIntegerBeautiful(long n, int target)
    */
    @Test
    public void testMakeIntegerBeautiful() throws Exception {
        long n = 6068060761L;
        int target = 3;
        long actual = solution.makeIntegerBeautiful(n, target);
        assertEquals(10000000000L - 6068060761L, actual);
    }


}
