package Contest0814.T4;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 08/14/2022
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
    * Method: countSpecialNumbers(int n)
    */
    @Test
    public void testCountSpecialNumbers() throws Exception {
        int n = 220;
        int expected = 178;
        int actual = solution.countSpecialNumbers(n);
        assertEquals(expected, actual);
    }


}
