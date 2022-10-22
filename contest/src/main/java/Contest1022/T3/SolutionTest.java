package Contest1022.T3;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 10/22/2022
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
    * Method: arrangeBookshelf(int[] order, int limit)
    */
    @Test
    public void testArrangeBookshelf() throws Exception {
        int[] order = {3,3,9,8,9,2,8};
        int limit = 1;
        int[] expected = {3, 8, 9, 2};
        int[] actual = solution.arrangeBookshelf(order, limit);
        assertArrayEquals(expected, actual);
    }


}
