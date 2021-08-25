package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * BoatsToSavePeopleSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 08/26/2021
 */
public class BoatsToSavePeopleSolutionTest {
    BoatsToSavePeopleSolution.Solution solution = new BoatsToSavePeopleSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: numRescueBoats(int[] people, int limit)
     */
    @Test
    public void testNumRescueBoats1() throws Exception {
        int[] people = {1, 2};
        int limit = 3;
        int expected = 1;
        int actual = solution.numRescueBoats(people, limit);
        assertEquals(expected, actual);
    }

    /**
     * Method: numRescueBoats(int[] people, int limit)
     */
    @Test
    public void testNumRescueBoats2() throws Exception {
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        int expected = 3;
        int actual = solution.numRescueBoats(people, limit);
        assertEquals(expected, actual);
    }

    /**
     * Method: numRescueBoats(int[] people, int limit)
     */
    @Test
    public void testNumRescueBoats3() throws Exception {
        int[] people = {3, 5, 3, 4};
        int limit = 5;
        int expected = 4;
        int actual = solution.numRescueBoats(people, limit);
        assertEquals(expected, actual);
    }


}
