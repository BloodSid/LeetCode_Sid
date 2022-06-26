package Contest0626;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 06/26/2022
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
    * Method: countHousePlacements(int n)
    */
    @Test
    public void testCountHousePlacements1() throws Exception {
        int n = 1;
        int expected = 4;
        int actual = solution.countHousePlacements(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testCountHousePlacements2() throws Exception {
        int n = 2;
        int expected = 9;
        int actual = solution.countHousePlacements(n);
        assertEquals(expected, actual);
    }

   @Test
    public void testCountHousePlacements3() throws Exception {
        int n = 1000;
        int expected = 500478595;
        int actual = solution.countHousePlacements(n);
        assertEquals(expected, actual);
    }


}
