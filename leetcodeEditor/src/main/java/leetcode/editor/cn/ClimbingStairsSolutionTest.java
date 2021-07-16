package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * ClimbingStairsSolution Tester.
 *
 * @author IronSid
 * @since 07/17/2021
 * @version 1.0
 */
public class ClimbingStairsSolutionTest {
    ClimbingStairsSolution.Solution solution = new ClimbingStairsSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: climbStairs(int n)
    */
    @Test
    public void testClimbStairs() throws Exception {
        int input = 3;
        int expected = 3,
        actual =
        solution.climbStairs(input);
        assertEquals(expected, actual);
    }


}
