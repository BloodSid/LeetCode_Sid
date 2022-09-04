package Contest0904.T4;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 09/04/2022
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
    * Method: mostBooked(int n, int[][] meetings)
    */
    @Test
    public void testMostBooked() throws Exception {
        int n = 2;
        int[][] meetings = {{0,10},{1,5},{2,7},{3,4}};
        int expected = 0;
        int actual = solution.mostBooked(n, meetings);
        assertEquals(expected, actual);
    }


}
