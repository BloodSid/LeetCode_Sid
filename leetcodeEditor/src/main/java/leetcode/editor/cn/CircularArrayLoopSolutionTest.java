package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * CircularArrayLoopSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 08/07/2021
 */
public class CircularArrayLoopSolutionTest {
    CircularArrayLoopSolution.Solution solution = new CircularArrayLoopSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: circularArrayLoop(int[] nums)
     */
    @Test
    public void testCircularArrayLoop1() throws Exception {
        int[] nums = {2, -1, 1, 2, 2};
        boolean actual =
                solution.circularArrayLoop(nums);
        assertEquals(true, actual);
    }

    /**
     * Method: circularArrayLoop(int[] nums)
     */
    @Test
    public void testCircularArrayLoop2() throws Exception {
        int[] nums = {-1, 2};
        boolean actual =
                solution.circularArrayLoop(nums);
        assertEquals(false, actual);
    }

    /**
     * Method: circularArrayLoop(int[] nums)
     */
    @Test
    public void testCircularArrayLoop3() throws Exception {
        int[] nums = {-2, 1, -1, -2, -2};
        boolean actual =
                solution.circularArrayLoop(nums);
        assertEquals(false, actual);
    }
    /**
     * Method: circularArrayLoop(int[] nums)
     */
    @Test
    public void testCircularArrayLoop4() throws Exception {
        int[] nums = {2,2,2,2,2,4,7};
        boolean actual =
                solution.circularArrayLoop(nums);
        assertEquals(false, actual);
    }


}
