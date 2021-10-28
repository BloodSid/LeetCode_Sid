package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * SelfCrossingSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 10/28/2021
 */
public class SelfCrossingSolutionTest {
    SelfCrossingSolution.Solution solution = new SelfCrossingSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: isSelfCrossing(int[] distance)
     */
    @Test
    public void testIsSelfCrossing1() throws Exception {
        int[] distance = {2, 1, 1, 2};
        boolean expected = true;
        boolean actual = solution.isSelfCrossing(distance);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsSelfCrossing2() throws Exception {
        int[] distance = {1, 2, 3, 4};
        boolean expected = false;
        boolean actual = solution.isSelfCrossing(distance);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsSelfCrossing3() throws Exception {
        int[] distance = {1, 1, 1, 1};
        boolean expected = true;
        boolean actual = solution.isSelfCrossing(distance);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsSelfCrossing4() throws Exception {
        int[] distance = {1, 1, 2, 1, 1};
        boolean expected = true;
        boolean actual = solution.isSelfCrossing(distance);
        assertEquals(expected, actual);
    }

}
